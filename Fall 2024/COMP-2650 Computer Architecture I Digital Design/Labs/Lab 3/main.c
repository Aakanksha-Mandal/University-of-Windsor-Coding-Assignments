#include <stdio.h>
#include <string.h>
#define MAX 8 // Number of bits in a byte

// Function to input a binary number with validation
void input_binary(const char *prompt, int binary[], char var) {
    printf("%s\n", prompt);
    char input[10]; // Buffer for user input

    for (int i = 0; i < MAX; i++) {
        while (1) {
            printf("%c%d = ", var, i);
            fgets(input, sizeof(input), stdin); // Read input as a string

            // Check if input is exactly one character long and is either '0' or '1'
            if (strlen(input) == 2 && (input[0] == '0' || input[0] == '1')) {
                binary[i] = input[0] - '0'; // Convert character to integer (0 or 1)
                break; // Valid input, exit loop
            } else {
                printf("Error: Please enter 0 or 1 only.\n\n");
            }
        }
    }
}

// print the binary number
void print_binary(const int binary[]) {
    for (int i = 0; i < MAX; i++) {
        printf("%d", binary[i]);
    }
    printf("\n");
}

// AND operation
void func_and(int a[], int b[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = a[i] & b[i];
    }
}

// OR operation
void func_or(int a[], int b[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = a[i] | b[i];
    }
}

// NOT operation
void func_not(int a[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = !a[i];
    }
}

// 1's complement (same as NOT)
void func_1s_comp(int a[], int result[]) {
    func_not(a, result);
}

// 2's complement
void func_2s_comp(int a[], int result[]) {
    func_1s_comp(a, result);
    // Add 1 to the result (manual binary addition)
    int carry = 1;
    for (int i = MAX - 1; i >= 0; i--) {
        result[i] = result[i] + carry;
        if (result[i] == 2) {
            result[i] = 0;
        } else {
            carry = 0;
            break;
        }
    }
}

// 2's complement*
void func_2s_comp_star(int a[], int result[]) {
    int found_one = 0;
    for (int i = MAX - 1; i >= 0; i--) {
        if (found_one) {
            result[i] = !a[i]; // Flip bits after the first 1
        } else {
            result[i] = a[i];
            if (a[i] == 1) {
                found_one = 1; // First 1 found, start flipping
            }
        }
    }
}

int main(void) {
    setbuf(stdout, NULL);
    int command;
    int x[MAX];
    int y[MAX];
    int result[MAX];
    char input[100];

    while (1) {
        // Display the menu
        printf("Enter the command number:\n\t0) Exit\n\t1) AND\n\t2) OR\n\t3) NOT\n\t4) 1's complement\n\t5) 2's complement\n\t6) 2's complement*\nChoose: ");
        fgets(input, sizeof(input), stdin);
        
        if (strlen(input) > 2 || sscanf(input, "%d", &command) != 1) {
            printf("Error: Invalid input. Please enter 0, 1, 2, 3, 4, 5, or 6.\n\n");
            continue;
        }

        // Exit
        if (command == 0) {
            printf("Exiting...\n\n");
            break;
        } 
        // AND operation
        else if (command == 1) {
            input_binary("\nEnter the first binary number:", x, 'x');
            input_binary("\nEnter the second binary number:", y, 'y');
            func_and(x, y, result);
            printf("\nResult of AND operation:\n");
            print_binary(result);
            printf("\n");
        } 
        // OR operation
        else if (command == 2) {
            input_binary("\nEnter the first binary number:", x, 'x');
            input_binary("\nEnter the second binary number:", y, 'y');
            func_or(x, y, result);
            printf("\nResult of OR operation:\n");
            print_binary(result);
            printf("\n");
        } else if (command == 3) { // NOT operation
            input_binary("\nEnter the binary number:", x, 'x');
            func_not(x, result);
            printf("\nResult of NOT operation:\n");
            print_binary(result);
            printf("\n");
        }
        // 1's complement operation 
        else if (command == 4) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_not(x, result);
            printf("\nResult of 1's complement operation:\n");
            print_binary(result);
            printf("\n");
        }
        // 2's complement 
        else if (command == 5) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_2s_comp(x, result);
            printf("\nResult of 2's complement operation:\n");
            print_binary(result);
            printf("\n");
        }
        // 2's complement* 
        else if (command == 6) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_2s_comp_star(x, result);
            printf("Result of 2's complement* operation:\n");
            print_binary(result);
            printf("\n");
        } 
        // Erorr handling
        else {
            printf("Error: Invalid command. Please choose a valid option.\n\n");
        }
    }
    return 0;
}
