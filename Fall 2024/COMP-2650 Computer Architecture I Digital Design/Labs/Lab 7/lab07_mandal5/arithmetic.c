#include "arithmetic.h"
#include "complement.h"
#include <stdio.h>

#define MAX 8 // Byte = 8 bits

// Helper variable
int overflow = 0;

// Helper function to handle overflow check
void check_overflow(int overflow) {
    if (overflow == 1) {
        printf("Warning: Overflow occurred.\n\n");
    }
}

// Helper function to set the value of overflow
void set_overflow(int o) {
    overflow = o;
}

// Helper function to get the value of overflow
int get_overflow() {
    return overflow;
}

// Helper function to determine the sign based on comparison to 127.5
int get_sign(const int a[]) {
    int unsigned_value = 0;
    for (int i = 0; i < MAX; i++) {
        unsigned_value = (unsigned_value << 1) | a[i];
    }
    return unsigned_value > 127;  // Returns 1 if negative, 0 if positive
}

// Addition function using two's complement
void func_signed_2s_addition(int a[], int b[], int result[]) {
    int carry = 0;
    overflow = 0; // Reset overflow

    int sign_a = get_sign(a);
    int sign_b = get_sign(b);

    // Perform binary addition from least significant bit to most significant bit
    for (int i = MAX - 1; i >= 0; i--) {
        int sum = a[i] + b[i] + carry;
        result[i] = sum % 2;  // Store the result bit
        carry = sum / 2;      // Update carry
    }

    int sign_result = get_sign(result);

    // Detect overflow based on the specified conditions
    if ((sign_a == 0 && sign_b == 0 && sign_result == 1) || // (+A) + (+B) = -result
        (sign_a == 1 && sign_b == 1 && sign_result == 0)) { // (-A) + (-B) = +result
        set_overflow(1);
        check_overflow(overflow);
    }
}

// Subtraction function using two's complement
void func_signed_2s_subtraction(int a[], int b[], int result[]) {
    int twos_complement_b[MAX];

    // Calculate the two's complement of b using func_2s_comp from complement.h
    func_2s_comp(b, twos_complement_b);

    // Add a and the two's complement of b
    func_signed_2s_addition(a, twos_complement_b, result);
}