// arithmetic.h
#ifndef ARITHMETIC_H
#define ARITHMETIC_H

// Function protoypes
void func_signed_mag_addition(int a[], int b[], int result[]);
void func_signed_mag_subtraction(int a[], int b[], int result[]);
int check_overflow(int result[], int carry);
int get_sign(const int a[]);
void set_carry(int c);
int get_carry();
int compare_magnitude(const int a[], const int b[]);

#endif // ARITHMETIC_H
