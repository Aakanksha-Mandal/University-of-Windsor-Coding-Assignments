#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    if (argc != 4) {
        fprintf(stderr, "Usage: %s <operation> <operand1> <operand2>\n", argv[0]);
        return 1;
    }

    char operation = argv[1][0];
    int operand1 = atoi(argv[2]);
    int operand2 = atoi(argv[3]);

    // Generate `math.c` with the operation specified by the user
    FILE *file = fopen("math.c", "w");
    if (!file) {
        perror("fopen");
        return 1;
    }

    int fd = fileno(file);

    fprintf(file,
            "#include <stdio.h>\n"
            "int main() {\n"
            "    int a = %d;\n"
            "    int b = %d;\n"
            "    int result;\n"
            "    char operation = '%c';\n"
            "    if (operation == '+') result = a + b;\n"
            "    else if (operation == '-') result = a - b;\n"
            "    else if (operation == '*') result = a * b;\n"
            "    else if (operation == '/') result = b != 0 ? a / b : 0;\n"
            "    else result = 0;\n"
            "    printf(\"%%d %%c %%d = %%d\\n\", a, operation, b, result);\n"
            "    return 0;\n"
            "}\n",
            operand1, operand2, operation);

    fclose(file);

    // Fork a child process to compile `math.c`
    pid_t pid = fork();
    if (pid == 0) { // Child process
        printf("exec_math_bs pid: %d\n", getpid());
        execlp("gcc", "gcc", "math.c", "-o", "math", NULL);
        perror("execlp for gcc"); // If exec fails
        return 1;
    } else if (pid > 0) { // Parent process
        wait(NULL); // Wait for the child to finish compiling

        // Execute the compiled `math` program
        pid_t math_pid = fork();
        if (math_pid == 0) { // Child process
            printf("fd for math.c file: %d\n", fd);
            printf("math pid: %d\n", getpid());
            execlp("./math", "./math", NULL);
            perror("execlp for math"); // If exec fails
            return 1;
        } else if (math_pid > 0) { // Parent process
            wait(NULL); // Wait for the child to finish executing
        } else {
            perror("fork");
            return 1;
        }
    } else {
        perror("fork");
        return 1;
    }

    return 0;
}