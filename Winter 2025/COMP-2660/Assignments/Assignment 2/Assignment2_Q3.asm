INCLUDE C:\irvine\Irvine32.inc

.data
align 4
var1 BYTE 12h
var2 WORD 3456h
var3 DWORD 789ABCDEh
arr1 DWORD 10, 21, 30, 41, 50, 61, 70, 81, 90, 101
arr2 DWORD 10 DUP(? )
msgArr1 BYTE "Original Array:", 0
msgArr2 BYTE "Copied Array:", 0

.code
main PROC
; Print original array
mov edx, OFFSET msgArr1
call WriteString
call Crlf
push OFFSET arr1
push LENGTHOF arr1
call PrintArray

; Copy arr1 to arr2
call CopyArrayIndexed

; Print copied array
mov edx, OFFSET msgArr2
call WriteString
call Crlf
push OFFSET arr2
push LENGTHOF arr2
call PrintArray

exit
main ENDP

; Copy Array using Indexed Indirect Addressing
CopyArrayIndexed PROC
mov esi, OFFSET arr1; Source array base address
mov edi, OFFSET arr2; Destination array base address
mov ecx, LENGTHOF arr1; Number of elements
mov ebx, 0; Index register

CopyLoop:
mov eax, [esi + ebx * 4]; Load arr1[ebx] into eax
mov[edi + ebx * 4], eax; Store in arr2[ebx]
inc ebx; Move to next index
cmp ebx, ecx; Compare index with array size
jl CopyLoop; Jump if less

ret
CopyArrayIndexed ENDP

; Print Array Procedure
PrintArray PROC
push ebp
mov ebp, esp
push esi
push ecx

mov ecx, [ebp + 8]; Load array length
mov esi, [ebp + 12]; Load array base address

PrintLoop :
mov eax, [esi]; Load current array element
call WriteInt; Print integer
mov al, ' '; Print space
call WriteChar
add esi, 4; Move to next DWORD
loop PrintLoop; Repeat for all elements

call Crlf; Print newline
pop ecx
pop esi
leave
ret 8
PrintArray ENDP
END main