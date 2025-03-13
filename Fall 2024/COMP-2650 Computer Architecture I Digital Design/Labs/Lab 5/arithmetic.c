#include "arithmetic.h"
#include <stdio.h>

#define MAX 8 // Byte = 8 bits

// Helper variable
int carry = 0;

// Helper function to handle overflow check
int check_overflow(int result[], int carry) {
    if (carry != 0) {
        printf("Warning: Overflow occurred.\n\n");
        return 1;
    }
    return 0;
}

// Helper function to check the sign of binary numbers (1st bit is the sign bit)
int get_sign(const int a[]) {
    return a[0];
}

// Helper function to set the value of carry
void set_carry(int c) {
    carry = c;
}

// Helper function to get the value of carry
int get_carry() {
    return carry;
}

// Compare the magnitudes of two signed-magnitude numbers
int compare_magnitude(const int a[], const int b[]) {
    for (int i = 1; i < MAX; i++) {
        if (a[i] > b[i]) return 1;  // a is larger
        if (a[i] < b[i]) return -1; // b is larger
    }
    return 0; // Magnitudes are equal
}

// Signed-magnitude addition
void func_signed_mag_addition(int a[], int b[], int result[]) {
    int carry = 0;
    int sign_a = get_sign(a);
    int sign_b = get_sign(b);

    // Case 1: +x + (+y) or -x + (-y)
    if (sign_a == sign_b) {
        // Both numbers have the same sign, perform simple magnitude addition
        for (int i = MAX - 1; i >= 1; i--) {
            int sum = a[i] + b[i] + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
        result[0] = sign_a; // The result takes the sign of both operands
        set_carry(carry);
        check_overflow(result, carry);
    }
    // Case 2: +x + (-y) or -x + (+y)
    else {
        int cmp = compare_magnitude(a, b);
        if (cmp == 0) {
            // Magnitudes are equal, result is 0
            for (int i = 1; i < MAX; i++) {
                result[i] = 0;
            }
            result[0] = 0; // 0 is positive
        } else if (cmp > 0) {
            // a's magnitude is larger, perform a - b
            for (int i = MAX - 1; i >= 1; i--) {
                int diff = a[i] - b[i] - carry;
                if (diff < 0) {
                    result[i] = diff + 2;
                    carry = 1;
                } else {
                    result[i] = diff;
                    carry = 0;
                }
            }
            result[0] = sign_a; // Result takes the sign of the larger magnitude
        } else {
            // b's magnitude is larger, perform b - a
            for (int i = MAX - 1; i >= 1; i--) {
                int diff = b[i] - a[i] - carry;
                if (diff < 0) {
                    result[i] = diff + 2;
                    carry = 1;
                } else {
                    result[i] = diff;
                    carry = 0;
                }
            }
            result[0] = sign_b; // Result takes the sign of the larger magnitude
        }
    }
}

// Signed-magnitude subtraction
void func_signed_mag_subtraction(int a[], int b[], int result[]) {
    int sign_a = get_sign(a);
    int sign_b = get_sign(b);

    // Change the signs according to the rules
    if (sign_a == 0 && sign_b == 0) {
        sign_b = 1;
    } else if (sign_a == 0 && sign_b == 1) {
        sign_b = 0;
    } else if (sign_a == 1 && sign_b == 0) {
        sign_b = 1;
    } else if (sign_a == 1 && sign_b == 1) {
        sign_b = 0;
    }

    // Modify the sign of b
    int modified_b[MAX];
    modified_b[0] = sign_b;
    for (int i = 1; i < MAX; i++) {
        modified_b[i] = b[i]; // Copy the magnitude
    }

    func_signed_mag_addition(a, modified_b, result);
}