INCLUDE C:\Irvine\Irvine32.inc

.data
promptA BYTE "Enter A: ", 0
promptB BYTE "Enter B: ", 0
promptC BYTE "Enter C: ", 0
promptD BYTE "Enter D: ", 0
promptE BYTE "Enter E: ", 0
resultMsg BYTE "Computed Result: ", 0

A SDWORD ?
B SDWORD ?
C_var SDWORD ?
D SDWORD ?
E SDWORD ?
result SDWORD ?

.code
main PROC
; Prompt and read A
mov edx, OFFSET promptA
call WriteString
call ReadInt
mov A, eax; Store input in A

; Prompt and read B
mov edx, OFFSET promptB
call WriteString
call ReadInt
mov B, eax; Store input in B

; Prompt and read C
mov edx, OFFSET promptC
call WriteString
call ReadInt
mov C_var, eax; Store input in C

; Prompt and read D
mov edx, OFFSET promptD
call WriteString
call ReadInt
mov D, eax; Store input in D

; Prompt and read E
mov edx, OFFSET promptE
call WriteString
call ReadInt
mov E, eax; Store input in E

; Compute (A - B)
mov eax, A; eax = A
sub eax, B; eax = A - B

; Compute (A - B)* (-C)
mov ebx, C_var
neg ebx; ebx = -C_var
imul ebx; eax = (A - B) * (-C) (signed multiplication)

; Compute [(A - B) * (-C)] / D
cdq; Sign extend eax into edx
idiv D; eax = [(A - B) * (-C)] / D(signed division)

; Compute [[(A - B) * (-C)] / D] + (-E)
mov ebx, E
neg ebx; ebx = -E
add eax, ebx; eax = [[(A - B) * (-C)] / D] + (-E)

mov result, eax; Store final result

; Display result
mov edx, OFFSET resultMsg
call WriteString
mov eax, result
call WriteInt
call Crlf

exit
main ENDP

END main