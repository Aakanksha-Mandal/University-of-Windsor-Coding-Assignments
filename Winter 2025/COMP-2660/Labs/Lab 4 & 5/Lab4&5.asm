; ======================================================================================================
; Author: Aakanksha Mandal
; Date: March 16, 2025
; Description: Bubble Sort algorithm to sort two arrays of signed 32 - bit integers in ascending order.
; ======================================================================================================

INCLUDE C:\irvine\Irvine32.inc

.data
array1 DWORD 5, -3, 8, 12, -7, 6, 4, 10, 2, 0
arraySize1 DWORD LENGTHOF array1
originalMsg1 BYTE "Original Array 1: ", 0
sortedMsg1 BYTE "Sorted Array 1: ", 0

array2 DWORD 23, 4, -1, 15, 2, 3, 8, 7, 10, 6
arraySize2 DWORD LENGTHOF array2
originalMsg2 BYTE "Original Array 2: ", 0
sortedMsg2 BYTE "Sorted Array 2: ", 0

.code
main PROC
; Display original array 1
mov edx, OFFSET originalMsg1
call WriteString
call Crlf
push OFFSET array1
push arraySize1
call PrintArray

; Perform Bubble Sort for array 1
push OFFSET array1
push arraySize1
call bubbleSort

; Display sorted array 1
mov edx, OFFSET sortedMsg1
call WriteString
call Crlf
push OFFSET array1
push arraySize1
call PrintArray

; Display original array 2
mov edx, OFFSET originalMsg2
call WriteString
call Crlf
push OFFSET array2
push arraySize2
call PrintArray

; Perform Bubble Sort for array 2
push OFFSET array2
push arraySize2
call bubbleSort

; Display sorted array 2
mov edx, OFFSET sortedMsg2
call WriteString
call Crlf
push OFFSET array2
push arraySize2
call PrintArray

exit
main ENDP

; Procedure to display the array using PrintArray
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

; Bubble Sort procedure
bubbleSort PROC
push ebp
mov ebp, esp
push esi
push ecx

mov ecx, [ebp + 8]; array size
mov esi, [ebp + 12]; array address

dec ecx; Outer loop : n - 1 passes

outerLoop :
mov ebx, ecx; Inner loop counter
mov edi, esi; Start of the array

innerLoop :
mov eax, [edi]; Load current element
mov edx, [edi + 4]; Load next element

cmp eax, edx; Compare current and next elements
jle noSwap; If current <= next, no swap needed

; Swap elements
mov[edi], edx
mov[edi + 4], eax

noSwap :
add edi, 4; Move to the next element
dec ebx
jnz innerLoop; Continue inner loop

loop outerLoop; Continue outer loop

leave
ret 8
bubbleSort ENDP

END main