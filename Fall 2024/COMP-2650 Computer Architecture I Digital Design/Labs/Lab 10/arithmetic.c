#define INPUT_VARIABLE_COUNT 3

void func_increment(int a[], int result[]){
	//result = (a + 1) in binary
    int carry = 1;
    for (int i = INPUT_VARIABLE_COUNT - 1; i >= 0; i--) {
        result[i] = a[i] + carry;
        if (result[i] == 2) {
            result[i] = 0;
            carry = 1;
        } else {
            carry = 0;
        }
    }
}
