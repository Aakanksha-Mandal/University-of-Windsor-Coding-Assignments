#define MAX 8//Byte = 8 bits

// 1's complement (same as NOT)
void func_1s_comp(int a[], int result[]) {
    for (int i = 0; i < MAX; i++) {
        result[i] = !a[i];
    }
}

// 2's complement
void func_2s_comp(int a[], int result[]) {
    func_1s_comp(a, result);
    // Add 1 to the result (manual binary addition)
    int carry = 1;
    for (int i = MAX - 1; i >= 0; i--) {
        result[i] = result[i] + carry;
        if (result[i] == 2) {
            result[i] = 0;
        } else {
            carry = 0;
            break;
        }
    }
}

// 2's complement*
void func_2s_comp_star(int a[], int result[]) {
    int found_one = 0;
    for (int i = MAX - 1; i >= 0; i--) {
        if (found_one) {
            result[i] = !a[i]; // Flip bits after the first 1
        } else {
            result[i] = a[i];
            if (a[i] == 1) {
                found_one = 1; // First 1 found, start flipping
            }
        }
    }
}
