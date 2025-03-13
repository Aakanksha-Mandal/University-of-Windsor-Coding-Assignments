// conversion.h
#ifndef CONVERSION_H
#define CONVERSION_H

// Function prototypes
int calculate_magnitude(int a[]);
void calculate_10s_complement_decimal(char magnitude_str[], char result[], int length);
void calculate_8s_complement_octal(char magnitude_str[], char result[], int length);
void calculate_16s_complement_hex(int magnitude_value, char result[]);
void to_decimal(int a[]);
void to_octal(int a[]);
void to_hexadecimal(int a[]);

#endif //CONVERSION_H
