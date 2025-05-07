INCLUDE C:\irvine\Irvine32.inc

.data
align 4
var1 BYTE 12h
var2 WORD 3456h
var3 DWORD 789ABCDEh
arr1 DWORD 10, 21, 30, 41, 50, 61, 70, 81, 90, 101
arr3 DWORD LENGTHOF arr1 DUP(? ); Array to store reversed even numbers.
str1 BYTE "Reversed even numbers: ", 0

.code
main PROC
mov esi, OFFSET arr1; Source array
mov edi, OFFSET arr3; Destination array
mov ecx, LENGTHOF arr1; Loop counter
mov ebp, esp; Store initial stack pointer

call ProcessEvenNumbers; Call the new procedure

call PrintReversedEvens; Call the print procedure

exit
main ENDP

ProcessEvenNumbers PROC
mov esi, OFFSET arr1
mov edi, OFFSET arr3
mov ecx, LENGTHOF arr1
mov ebp, esp
mov ebx, 0; Counter for even numbers

push_even_numbers :
mov eax, [esi]
test eax, 1
jnz skip_push
push eax
inc ebx; Increment even number counter

skip_push :
add esi, TYPE arr1
loop push_even_numbers

cmp ebx, 0; Check if any even numbers were pushed
je ProcessEvenNumbers_exit; If not, skip pop loop

pop_reverse_numbers :
cmp esp, ebp
je ProcessEvenNumbers_exit

pop eax
mov[edi], eax
add edi, TYPE arr3
jmp pop_reverse_numbers

ProcessEvenNumbers_exit :
ret
ProcessEvenNumbers ENDP

PrintReversedEvens PROC
mov edx, OFFSET str1; Print the message
call WriteString

mov esi, OFFSET arr1; Source array
mov ecx, LENGTHOF arr1; Loop counter
mov ebx, 0

count_even:
mov eax, [esi]
test eax, 1
jz increment_counter

jmp increment_esi

increment_counter :
inc ebx

increment_esi :
add esi, TYPE arr1
loop count_even

mov ecx, ebx; ecx now contains the number of even numbers

cmp ecx, 0
je PrintReversedEvens_exit

mov esi, OFFSET arr3; Source array
mov ebx, ecx; store even number count into ebx.

print_loop:
mov eax, [esi]
call WriteDec
mov al, ' '
call WriteChar

add esi, TYPE arr3
dec ebx; decrement the even number counter.
cmp ebx, 0
jnz print_loop; loop while ebx is not zero.

PrintReversedEvens_exit:
call Crlf
ret
PrintReversedEvens ENDP

END main