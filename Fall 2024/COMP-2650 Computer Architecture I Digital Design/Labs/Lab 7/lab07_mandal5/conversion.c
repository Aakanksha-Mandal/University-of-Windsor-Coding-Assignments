#include <stdio.h>
#include <math.h>
#include <string.h> 
#include <stdlib.h>
#include "complement.h"

#define MAX 8 // Number of bits in the binary number

// Function to calculate the magnitude
int calculate_magnitude(int a[]) {
    int magnitude = 0;
    for (int i = 0; i < MAX; i++) {
        magnitude += a[i] * pow(2, MAX - 1 - i);
    }
    return magnitude;
}

// Helper function to calculate 10's complement in decimal
void calculate_10s_complement_decimal(char magnitude_str[], char result[], int length) {
    // Calculate 9's complement
    for (int i = 0; i < length; i++) {
        result[i] = '9' - magnitude_str[i] + '0';
    }

    // Add 1 to the least significant bit
    int carry = 1;
    for (int i = length - 1; i >= 0; i--) {
        int sum = result[i] - '0' + carry;
        result[i] = (sum % 10) + '0';
        carry = sum / 10;
    }
}

// Helper function to calculate 8's complement in octal
void calculate_8s_complement_octal(char magnitude_str[], char result[], int length) {
    // Calculate 7's complement
    for (int i = 0; i < length; i++) {
        result[i] = '7' - magnitude_str[i] + '0';
    }

    // Add 1 to the least significant bit
    int carry = 1;
    for (int i = length - 1; i >= 0; i--) {
        int sum = result[i] - '0' + carry;
        result[i] = (sum % 8) + '0';
        carry = sum / 8;
    }
}

// Helper function to calculate 16's complement in hexadecimal
void calculate_16s_complement_hex(int magnitude_value, char result[]) {
    // Calculate the 16's complement
    int complement_value = (15 - magnitude_value + 1);

    // Convert this complement_value to hexadecimal
    int index = 0;

    // If the complement value is 0, directly assign '0'
    if (complement_value == 0) {
        result[index++] = '0';
    } else {
        // Convert the integer to hexadecimal
        while (complement_value > 0) {
            int digit = complement_value % 16;
            result[index++] = (digit < 10) ? (digit + '0') : (digit - 10 + 'A');
            complement_value /= 16;
        }
    }

    // Reverse the result string to get the correct hexadecimal representation
    for (int i = 0; i < index / 2; i++) {
        char temp = result[i];
        result[i] = result[index - 1 - i];
        result[index - 1 - i] = temp;
    }

    // Null-terminate the result string
    result[index] = '\0';
}

// Function to convert binary to decimal (signed-10's-complement)
void to_decimal(int a[]) {
    int is_negative = a[0];
    int magnitude;
    char result[12] = {0};

    if (is_negative) {
        int twos_complement[MAX];
        func_2s_comp(a, twos_complement);
        magnitude = calculate_magnitude(twos_complement);
    } else {
        magnitude = calculate_magnitude(a);
    }

    sprintf(result, "%d", magnitude);
    if (is_negative) {
        char complement_result[12] = {0};
        calculate_10s_complement_decimal(result, complement_result, strlen(result));
        printf("%s in Decimal (Signed-10's-Complement)\n", complement_result);
    } else {
        printf("%s in Decimal (Signed-10's-Complement)\n", result);
    }
}

// Function to convert binary to octal (signed-8's-complement)
void to_octal(int a[]) {
    int is_negative = a[0];
    int magnitude;
    char result[12] = {0};
    int index = 0;

    if (is_negative) {
        int twos_complement[MAX];
        func_2s_comp(a, twos_complement);
        magnitude = calculate_magnitude(twos_complement);
    } else {
        magnitude = calculate_magnitude(a);
    }

    if (magnitude == 0) {
        result[0] = '0';
    } else {
        while (magnitude > 0) {
            result[index++] = (magnitude % 8) + '0';
            magnitude /= 8;
        }
    }
    if (is_negative) {
        char complement_result[12] = {0};
        calculate_8s_complement_octal(result, complement_result, index);
        printf("%s in Octal (Signed-8's-Complement)\n", complement_result);
    } else {
        // Reverse the result for correct order
        for (int i = 0; i < index / 2; i++) {
            char temp = result[i];
            result[i] = result[index - 1 - i];
            result[index - 1 - i] = temp;
        }
        result[index] = '\0';
        printf("%s in Octal (Signed-8's-Complement)\n", result);
    }
}

// Function to convert binary to hexadecimal (signed-16's-complement)
void to_hexadecimal(int a[]) {
    int is_negative = a[0];
    int magnitude;
    char result[12] = {0};

    if (is_negative) {
        int twos_complement[MAX];
        func_2s_comp(a, twos_complement);
        magnitude = calculate_magnitude(twos_complement);
    } else {
        magnitude = calculate_magnitude(a);
    }

    // Calculate hexadecimal representation
    if (is_negative) {
        char complement_result[12] = {0};
        calculate_16s_complement_hex(magnitude, complement_result);
        printf("%s in Hexadecimal (Signed-16's-Complement)\n", complement_result);
    } else {
        // Convert positive magnitude to hexadecimal directly
        int index = 0;
        while (magnitude > 0) {
            int digit = magnitude % 16;
            result[index++] = (digit < 10) ? (digit + '0') : (digit - 10 + 'A');
            magnitude /= 16;
        }
        // Reverse the result for correct order
        for (int i = 0; i < index / 2; i++) {
            char temp = result[i];
            result[i] = result[index - 1 - i];
            result[index - 1 - i] = temp;
        }
        result[index] = '\0';
        printf("%s in Hexadecimal (Signed-16's-Complement)\n", result);
    }
}