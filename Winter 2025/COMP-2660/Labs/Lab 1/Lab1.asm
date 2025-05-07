; Adding two variables
Include C:\irvine\Irvine32.inc

ExitProcess proto, dwExitCode:dword

.data
Var1 dword 10000h
Var2 dword 20000h
result1 dword 0

Var3 dword 3
Var4 dword -5
result2 dword 0

.code
main proc
	mov eax, Var1
	add eax, Var2
	mov result1, eax
	call dumpregs

	mov eax, Var3
	add eax, Var4
	mov result2, eax
	call dumpregs

	invoke ExitProcess, 0
main endp
end main

/* Lab 1 Answers
Q1. What is the final value of the EAX register ?
	The final value of the EAX register is 10000h (65,536 in decimal) + 20000h (131,072 in decimal)= 30000h (196,608 in decimal).

Q2. What will be different if we decide to add two signed values +3 and -5, create new variables Var3 and Var4 assign these values, 
test your program and content of EAX registers.
	The assembler will interpret the data as signed integers.
	The final value of the EAX register is 00000003 (+3 in decimal) + FFFFFFFB (-5 in decimal)= FFFFFFFE (-2 in decimal).
*/