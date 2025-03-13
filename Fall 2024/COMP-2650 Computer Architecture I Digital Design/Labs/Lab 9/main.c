#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include "arithmetic.h"

#define INPUT_VARIABLE_COUNT 3
#define OUTPUT_VARIABLE_COUNT 1
#define TRUTH_TABLE_ROW_COUNT (1 << INPUT_VARIABLE_COUNT) //2^INPUT_VARIABLE_COUNT

//int TRUTH_TABLE_ROW_COUNT = (int)pow(2, INPUT_VARIABLE_COUNT);

void build_left_side(int truth_table[][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT]) {
    // Initialize the first row to all zeros
    int row[INPUT_VARIABLE_COUNT] = {0};  // Start with binary '000'

    // Copy initial row to the first row of the truth table
    for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
        truth_table[0][j] = row[j];
    }

    // Generate all other rows by incrementing the binary number
    for (int i = 1; i < TRUTH_TABLE_ROW_COUNT; i++) {
        int next_row[INPUT_VARIABLE_COUNT] = {0};  // Temporary array for the next row
        func_increment(row, next_row);  // Increment the current row to get the next binary row

        // Copy next_row to row for further increments
        for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
            row[j] = next_row[j];
            truth_table[i][j] = row[j];  // Populate the truth table row
        }
    }
}

void build_right_side(int truth_table[][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT]) {
    // Build the right side of the truth table for the output variables
    for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
        for (int j = 0; j < OUTPUT_VARIABLE_COUNT; j++) {
            char input[10]; // Buffer to hold user input
            int output;

            while (1) {
                printf("Output value for row# %d of F%d output variable (0 or 1): ", i, j + 1);
                fgets(input, sizeof(input), stdin); // Read user input

                // Check if the input is valid: only one character long and is either '0' or '1'
                if (strlen(input) == 2 && (input[0] == '0' || input[0] == '1') && input[1] == '\n') {
                    output = atoi(input); // Convert string to integer
                    truth_table[i][INPUT_VARIABLE_COUNT + j] = output;
                    break; // Exit the loop once valid input is entered
                } else {
                    printf("Invalid input! Please enter 0 or 1.\n\n");
                }
            }
        }
    }
}

void to_minterm(int truth_table[][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT]) {
    for (int j = 0; j < OUTPUT_VARIABLE_COUNT; j++) {
        printf("output variable F%d = ∑m(", j + 1);
        int first_minterm = 1; // Flag to handle comma placement
        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            // Check if the output is 1 for this row and output variable
            if (truth_table[i][INPUT_VARIABLE_COUNT + j] == 1) {
                if (!first_minterm) {
                    printf(", ");
                }
                first_minterm = 0;
                printf("%d", i); // Print the minterm index
            }
        }
        printf(") = ");
        int is_first_term = 1;
        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            // Check if the output is 1 for this row and output variable
            if (truth_table[i][INPUT_VARIABLE_COUNT + j] == 1) {
                // Print '+' before each minterm except the first one
                if (!is_first_term) {
                    printf(" + ");
                }
                is_first_term = 0;
                // Generate the minterm for this row
                for (int k = 0; k < INPUT_VARIABLE_COUNT; k++) {
                    if (truth_table[i][k] == 0) {
                        printf("%c'", 'Z' - k);
                    } else {
                        printf("%c", 'Z' - k);
                    }
                }
            }
        }
        printf("\n");
    }
}

int main(void) {

	setbuf(stdout, NULL);

	//Wrong! ^ operator in C/C++ is the bitwise XOR logic operator.
	//int TRUTH_TABLE_ROW_COUNT = 2^INPUT_VARIABLE_COUNT;

	int truth_table[TRUTH_TABLE_ROW_COUNT][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT] = {0};
	const char variables[INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT] =  {'Z', 'Y', 'X', 'F'};
    int command;
    char input[100];

    while (1) {
        // Display the menu
        printf("Enter the command number:\n\t0) Exit\n\t1) Canonical SoP\nChoose: ");
        fgets(input, sizeof(input), stdin);

        if (strlen(input) > 2 || sscanf(input, "%d", &command) != 1) {
            printf("Error: Invalid input. Please enter 0 or 1.\n\n");
            continue;
        }

        // Exit
        if (command == 0) {
            printf("Exiting...\n\n");
            break;
        }

        printf("\n");
        build_left_side(truth_table);
        build_right_side(truth_table);

        //printing the header of truth table with variable names for inputs and outputs
        printf("\n");
        //printing the header for input variables
        for(int i = 0; i < INPUT_VARIABLE_COUNT; i = i + 1){
            printf("%c, ", variables[i]);
        }
        printf(" : ");

        //printing the header for output variables
        for(int i = INPUT_VARIABLE_COUNT; i < INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT; i = i + 1){
            printf("%c", variables[i]);
        }
        printf("\n");

        //printing the content of each row
        for(int i = 0; i < TRUTH_TABLE_ROW_COUNT; i = i + 1){

            //printing the content of each row regarding the input variables
            for(int j = 0; j < INPUT_VARIABLE_COUNT; j = j + 1){
                printf("%d, ", truth_table[i][j]);
            }
            printf(" : ");

            //printing the content of each row regarding the output variables
            for(int j = INPUT_VARIABLE_COUNT; j < INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT; j = j + 1){
                printf("%d", truth_table[i][j]);
            }
            printf("\n");
        }
        //printing the boolean function for F1 in the form of a sum of minterms (canonical SoP)
        to_minterm(truth_table);
        printf("\n");
    }
}