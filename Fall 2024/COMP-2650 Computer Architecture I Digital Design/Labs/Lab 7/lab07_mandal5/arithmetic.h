// arithmetic.h
#ifndef ARITHMETIC_H
#define ARITHMETIC_H

// Function protoypes
void func_signed_2s_addition(int a[], int b[], int result[]);
void func_signed_2s_subtraction(int a[], int b[], int result[]);
void check_overflow(int overflow);
int get_overflow();
void set_overflow(int o);
int get_sign(const int a[]);
int compare_magnitude(const int a[], const int b[]);
void func_2s_comp(int a[], int result[]);

#endif // ARITHMETIC_H
