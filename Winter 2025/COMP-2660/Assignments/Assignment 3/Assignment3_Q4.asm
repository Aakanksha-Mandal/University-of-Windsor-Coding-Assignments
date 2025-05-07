INCLUDE C:\Irvine\Irvine32.inc

.data
prompt BYTE "Enter a string: ", 0
inputBuffer BYTE 128 DUP(? )
sumMsg BYTE "Sum of individual digits is: ", 0
sum DWORD 0
temp BYTE 0

.code
main PROC
; Display prompt
mov edx, OFFSET prompt
call WriteString

; Read input string
mov edx, OFFSET inputBuffer
mov ecx, SIZEOF inputBuffer - 1; Maximum characters to read
call ReadString

; Initialize sum to 0
mov sum, 0

; Loop through the input string
mov esi, OFFSET inputBuffer; esi points to the current character

loop_start :
mov al, [esi]; Get the current character
cmp al, 0; Check for null terminator
je loop_end

cmp al, '0'; Check if it's a digit
jl next_char

cmp al, '9'; Check if it's a digit
jg next_char

; It's a digit, convert it to a number and add to sum
sub al, '0'; Convert ASCII digit to numerical value
movzx eax, al
add sum, eax

next_char :
inc esi; Move to the next character
jmp loop_start

loop_end :
; Display the sum
mov edx, OFFSET sumMsg
call WriteString

mov eax, sum
call WriteDec

exit
main ENDP

END main
