#include <stdio.h>
#include <string.h>
#include "logic.h"
#include "complement.h"
#include "conversion.h"
#define MAX 8 // Byte = 8 bits

// Function to input a binary number
void input_binary(const char *prompt, int binary[], char var) {
    printf("%s\n", prompt);
    char input[10];

    for (int i = 0; i < MAX; i++) {
        while (1) {
            printf("%c%d = ", var, i); 
            fgets(input, sizeof(input), stdin);

            // Check if input is exactly one character long and is either '0' or '1'
            if (strlen(input) == 2 && (input[0] == '0' || input[0] == '1')) {
                binary[i] = input[0] - '0';
                break;
            } else {
                printf("Error: Please enter 0 or 1 only.\n\n");
            }   
        }   
    }   
}

// Convert binary array to a string representation
void binary_to_string(const int binary[], char* output) {
    for (int i = 0; i < MAX; i++) {
        output[i] = binary[i] + '0';
    }
    output[MAX] = '\0';
}

// Print the binary number
void print_binary(const int binary[]) {
    for (int i = 0; i < MAX; i++) {
        printf("%d", binary[i]);
    }   
    printf(" in Binary\n");
}

// Get the operation name for printing
const char* get_operation_name(int command) {
    switch (command) {
        case 1: return "AND";
        case 2: return "OR";
        case 3: return "NOT";
        case 4: return "1's complement";
        case 5: return "2's complement";
        case 6: return "2's complement*";
        default: return "";
    }
}

int main(void) {
    setbuf(stdout, NULL);
    int command, base;
    int x[MAX], y[MAX], result[MAX];
    char input[100], bin_x[MAX + 1], bin_y[MAX + 1];

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

        // AND
        if (command == 1) {
            input_binary("\nEnter the first binary number:", x, 'x');
            input_binary("\nEnter the second binary number:", y, 'y');
            func_and(x, y, result);
        }
        // OR 
        else if (command == 2) {
            input_binary("\nEnter the first binary number:", x, 'x');
            input_binary("\nEnter the second binary number:", y, 'y');
            func_or(x, y, result);
        } 
        // NOT
        else if (command == 3) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_not(x, result);
        } 
        // 1's complement
        else if (command == 4) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_1s_comp(x, result);
        } 
        // 2's complement
        else if (command == 5) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_2s_comp(x, result);
        } 
        // 2's complement*
        else if (command == 6) {
            input_binary("\nEnter the binary number:", x, 'x');
            func_2s_comp_star(x, result);
        } else {
            printf("Error: Invalid command. Please choose a valid option.\n\n");
            continue;
        }

        // Convert the binary inputs to strings for output
        binary_to_string(x, bin_x);
        if (command == 1 || command == 2) {
            binary_to_string(y, bin_y);
        }

        // Asking for the output base
        while (1) {
            printf("\nEnter the output base:\n\t1) Binary\n\t2) Octal\n\t3) Decimal\n\t4) Hexadecimal\nChoose: ");
            fgets(input, sizeof(input), stdin);
            if (sscanf(input, "%d", &base) == 1 && base >= 1 && base <= 4) {
                break;
            } else {
                printf("Error: Invalid base selection. Please enter 1, 2, 3, or 4.\n");
            }
        }

        // Display the result in the chosen base
        const char* operation = get_operation_name(command);
        
        // Handle potential double space here
        if (command == 1 || command == 2) {
            printf("\n%s %s %s is ", bin_x, operation, bin_y);
        } else {
            printf("\n%s %s is ", bin_x, operation);
        }

        switch (base) {
            // Binary
            case 1:
                print_binary(result);
                break;
            // Octal
            case 2:
                to_octal(result);
                break;
            // Decimal
            case 3:
                to_decimal(result);
                break;
            // Hexadecimal
            case 4:
                to_hexadecimal(result);
                break;
        }
        printf("\n");
    }
    return 0;
}