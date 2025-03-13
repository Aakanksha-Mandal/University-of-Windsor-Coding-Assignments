#include <stdio.h>
#include <math.h>

#define MAX 8

// Convert binary to decimal
void to_decimal(int a[]) {
    int number = 0;

    // Convert binary array to decimal
    for (int i = 0; i < MAX; i++) {
        number += a[i] * pow(2, MAX - 1 - i);
    }

    // Handle printing of the decimal number manually
    if (number == 0) {
        putchar('0'); // Special case for 0
    } else {
        if (number < 0) {
            putchar('-'); // Handle negative numbers
            number = -number;
        }

        // Extract digits of the decimal number
        char digits[10]; // Assume a maximum of 10 digits (this should be enough for an 8-bit binary number)
        int index = 0;

        while (number > 0) {
            digits[index++] = (number % 10) + '0'; // Store the last digit as a character
            number /= 10; // Remove the last digit
        }

        // Print the digits in reverse order (since we extracted them from least significant to most significant)
        for (int i = index - 1; i >= 0; i--) {
            putchar(digits[i]);
        }
    }
    printf(" in Decimal\n");
}

// Convert binary to octal
void to_octal(int a[]) {
    int decimal = 0;
    int octal = 0;
    int base = 1;

    // Convert binary to decimal
    for (int i = 0; i < MAX; i++) {
        decimal = decimal * 2 + a[i];
    }

    // Convert decimal to octal
    if (decimal == 0) {
        putchar('0'); // Special case for 0
    } else {
        char octal_digits[12]; // Assume a maximum of 12 digits for octal representation
        int index = 0;

        // Convert decimal to octal
        while (decimal > 0) {
            octal_digits[index++] = (decimal % 8) + '0'; // Store the last octal digit as a character
            decimal /= 8; // Remove the last octal digit
        }
        // Print the octal digits in reverse order
        for (int i = index - 1; i >= 0; i--) {
            putchar(octal_digits[i]);
        }
    }

    printf(" in Octal\n");
}

// Convert binary to hexadecimal
void to_hexadecimal(int a[]) {
    int decimal = 0;

    // Convert binary to decimal first
    for (int i = 0; i < MAX; i++) {
        decimal += a[i] * pow(2, MAX - 1 - i); // Multiply each bit by 2^position
    }

    // Convert decimal to hexadecimal manually
    char hex_result[MAX / 4 + 1]; // To hold hexadecimal result (2 characters for 8-bit binary)
    int index = 0;

    if (decimal == 0) {
        hex_result[index++] = '0';
    } else {
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hex_result[index++] = remainder + '0'; // 0-9 as characters
            } else {
                hex_result[index++] = remainder - 10 + 'A'; // A-F as characters
            }
            decimal /= 16;
        }
    }
    hex_result[index] = '\0';

    // Since the result is in reverse order, we need to reverse the hex_result
    for (int i = 0; i < index / 2; i++) {
        char temp = hex_result[i];
        hex_result[i] = hex_result[index - 1 - i];
        hex_result[index - 1 - i] = temp;
    }
    // Print the hexadecimal result
    printf("%s in Hexadecimal\n", hex_result);
}
