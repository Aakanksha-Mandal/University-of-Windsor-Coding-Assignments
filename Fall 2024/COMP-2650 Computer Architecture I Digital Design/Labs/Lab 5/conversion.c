#include <stdio.h>
#include <math.h>

#define MAX 8

// Helper function to calculate the magnitude (ignoring the sign bit)
int calculate_magnitude(int a[]) {
    int magnitude = 0;
    for (int i = 1; i < MAX; i++) { // Ignore the first bit (sign bit)
        magnitude += a[i] * pow(2, MAX - 1 - i);
    }
    return magnitude;
}

// Convert binary to decimal (signed-magnitude)
void to_decimal(int a[]) {
    int magnitude = calculate_magnitude(a);
    int sign = a[0]; // Check the sign bit

    if (sign != 0) {
        printf("-"); // Output negative sign for negative numbers
    } else {
        printf("+"); // Output positive sign for positive numbers
    }

    // Print the decimal value
    printf("%d in Decimal\n", magnitude);
}

// Convert binary to octal (signed-magnitude)
void to_octal(int a[]) {
    int magnitude = calculate_magnitude(a);
    int sign = a[0]; // Check the sign bit

    if (sign != 0) {
        printf("-"); // Output negative sign for negative numbers
    } else {
        printf("+"); // Output positive sign for positive numbers
    }

    // Convert magnitude to octal
    char octal_digits[12]; // Assume a maximum of 12 digits for octal
    int index = 0;

    if (magnitude == 0) {
        putchar('0'); // Special case for 0
    } else {
        while (magnitude > 0) {
            octal_digits[index++] = (magnitude % 8) + '0'; // Store octal digit
            magnitude /= 8; // Remove the last octal digit
        }
        // Print the octal digits in reverse order
        for (int i = index - 1; i >= 0; i--) {
            putchar(octal_digits[i]);
        }
    }

    printf(" in Octal\n");
}

// Convert binary to hexadecimal (signed-magnitude)
void to_hexadecimal(int a[]) {
    int magnitude = calculate_magnitude(a);
    int sign = a[0]; // Check the sign bit

    if (sign != 0) {
        printf("-"); // Output negative sign for negative numbers
    } else {
        printf("+"); // Output positive sign for positive numbers
    }

    // Convert magnitude to hexadecimal
    char hex_result[MAX / 4 + 1]; // To hold hexadecimal result
    int index = 0;

    if (magnitude == 0) {
        hex_result[index++] = '0';
    } else {
        while (magnitude > 0) {
            int remainder = magnitude % 16;
            if (remainder < 10) {
                hex_result[index++] = remainder + '0'; // 0-9 as characters
            } else {
                hex_result[index++] = remainder - 10 + 'A'; // A-F as characters
            }
            magnitude /= 16;
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