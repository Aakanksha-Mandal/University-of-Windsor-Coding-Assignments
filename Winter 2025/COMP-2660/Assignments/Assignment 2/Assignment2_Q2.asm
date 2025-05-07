INCLUDE C:\irvine\Irvine32.inc

.data
align 4
var1 BYTE 12h
var2 WORD 3456h
var3 DWORD 789ABCDEh
arr1 DWORD 10, 21, 30, 41, 50, 61, 70, 81, 90, 101
str1 BYTE "Matrix contents:", 0
matrix DWORD 4 DUP(4 DUP(? )); 4x4 Matrix
uninit DWORD ?

.code
main PROC
call InitializeMatrix
call PrintMatrix
exit
main ENDP

InitializeMatrix PROC
mov esi, OFFSET matrix; Pointer to the matrix
mov eax, 1; Starting value
mov ecx, 4; Outer loop(rows)

outer_loop:
push ecx; Save outer loop counter
mov ecx, 4; Inner loop(columns)

inner_loop:
mov[esi], eax; Store the value in the matrix
add esi, TYPE DWORD; Move to the next element
inc eax; Increment the value
loop inner_loop

pop ecx; Restore outer loop counter
loop outer_loop

ret
InitializeMatrix ENDP

PrintMatrix PROC
mov edx, OFFSET str1; Print the message
call WriteString
call Crlf

mov esi, OFFSET matrix; Pointer to the matrix
mov ecx, 4; Outer loop(rows)

print_outer_loop:
push ecx; Save outer loop counter
mov ecx, 4; Inner loop(columns)

print_inner_loop:
mov eax, [esi]; Get the value from the matrix
call WriteDec; Print the value
mov al, ' '; Print a space
call WriteChar
add esi, TYPE DWORD; Move to the next element
loop print_inner_loop

call Crlf; Print a new line after each row
pop ecx; Restore outer loop counter
loop print_outer_loop

ret
PrintMatrix ENDP

END main