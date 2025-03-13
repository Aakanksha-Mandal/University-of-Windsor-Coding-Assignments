#include <stdio.h>
#include <string.h>

int main(void) {
    setbuf(stdout, NULL);
    int x, y, command;
    char input[100];

    while (1) {
        printf("Enter the command number:\n\t0) Exit\n\t1) AND\n\t2) OR\nChoose: ");
        fgets(input, sizeof(input), stdin);

        // Check if input length is more than 2 (1 for command + 1 for newline)
        if (strlen(input) > 2 || sscanf(input, "%d", &command) != 1) {
            printf("Error: Invalid input. Please enter 0, 1, or 2.\n\n");
            continue;
        }

        if (command == 0) {
            printf("Exiting...\n\n");
            break;
        }

        if (command == 1 || command == 2) {
            while (1) {
                printf("x = ");
                fgets(input, sizeof(input), stdin);
                if (sscanf(input, "%d", &x) > 2 || (x != 0 && x != 1)) {
                    printf("Error: Invalid boolean. Please choose 0 or 1 for x.\n\n");
                    continue;
                }

                printf("y = ");
                fgets(input, sizeof(input), stdin);
                if (sscanf(input, "%d", &y) > 2 || (y != 0 && y != 1)) {
                    printf("Error: Invalid boolean. Please choose 0 or 1 for y.\n\n");
                    continue;
                }

                break; // Exit the loop when both x and y are valid
            }

            // Perform the appropriate operation
            if (command == 1) {
                printf("%d AND %d is %d\n\n", x, y, x & y);
            } else if (command == 2) {
                printf("%d OR %d is %d\n\n", x, y, x | y);
            }
        } else {
            printf("Error: Invalid command. Please choose 0, 1, or 2.\n\n");
        }
    }

    return 0;
}