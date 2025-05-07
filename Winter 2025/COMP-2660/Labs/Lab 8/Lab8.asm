INCLUDE C:\Irvine\Irvine32.inc

.data
A DWORD 10
B DWORD 5
C_var DWORD 3
D DWORD 20
E DWORD 2
result DWORD ?
resultMsg BYTE "Result: ", 0

.code
main PROC
; Calculate(A + B)
mov eax, A
add eax, B
push eax; Push(A + B) onto the stack

; Calculate(A + B) / C
pop eax; Pop(A + B) into eax
mov ebx, C_var
xor edx, edx; Clear EDX for division
div ebx; EAX = (A + B) / C, EDX = remainder
push eax; Push((A + B) / C) onto the stack

; Calculate(D - A)
mov eax, D
sub eax, A
push eax; Push(D - A) onto the stack

; Calculate((A + B) / C)* (D - A)
pop eax; Pop(D - A) into eax
pop ebx; Pop((A + B) / C) into ebx
mul ebx; EAX = ((A + B) / C) * (D - A)
push eax; Push the intermediate result onto the stack

; Calculate(((A + B) / C) * (D - A)) + E
pop eax; Pop the intermediate result into eax
add eax, E
mov result, eax; Store the final result

; Display the result
mov edx, OFFSET resultMsg
call WriteString
mov eax, result
call WriteDec
call Crlf

exit
main ENDP

END main