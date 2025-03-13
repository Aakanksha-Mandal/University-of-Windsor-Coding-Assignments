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

int main(void) {

	setbuf(stdout, NULL);

	//Wrong! ^ operator in C/C++ is the bitwise XOR logic operator.
	//int TRUTH_TABLE_ROW_COUNT = 2^INPUT_VARIABLE_COUNT;

	int truth_table[TRUTH_TABLE_ROW_COUNT][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT] = {0};

	const char variables[INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT] =  {'Z', 'Y', 'X', 'F'};

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

	return 0;
}



