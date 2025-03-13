#define MAX 8//Byte = 8 bits

// AND operation
void func_and(int a[], int b[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = a[i] & b[i];
    }
}

// OR operation
void func_or(int a[], int b[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = a[i] | b[i];
    }
}

// NOT operation
void func_not(int a[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = !a[i];
    }
}
