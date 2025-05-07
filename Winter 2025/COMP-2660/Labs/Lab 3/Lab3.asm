Include C:\irvine\Irvine32.inc

.data
A DWORD 20
B DWORD 10
C_var DWORD 5
D DWORD 50
E DWORD 15
Result DWORD ?

ptrA DWORD A
ptrB DWORD B
ptrC DWORD C_var
ptrD DWORD D
ptrE DWORD E

.code

main PROC
	;1.Indirect Addressing
	mov esi, ptrA ;ESI points to A
	mov edi, ptrB ;EDI points to B
	mov ebx, ptrC ;EBX points to C_var
	mov edx, ptrD ;EDX points to D
	mov ecx, ptrE ;ECX points to E
	call DumpRegs

	;2.a)sumAB = A + B
	mov eax, [esi] ;Move A to EAX
	add eax, [edi] ;EAX =  A + B
	call DumpRegs

	;2.b)prodABC = sumAB * C (without using MUL)
	mov ecx, [ebx] ;Move C to ECX
	mov ebx, 0 ;EBX will store the product
	call DumpRegs
	
sum_loop :
	add ebx, eax ;EBX += sumAB
	loop sum_loop ;Repeat C times
	call DumpRegs

	;2.c)diffDE = D - E
	mov eax, [edx] ;Move D to EAX
	mov ecx, OFFSET E
	sub eax, [ecx] ;EAX = D - E
	call DumpRegs

	;2.d)Result = prodABC - diffDE
	sub ebx, eax ;EBX = prodABC - diffDE
	mov Result, ebx ;Store the final result

	;3.Display result
	mov eax, Result
	call DumpRegs
	call WriteHex

	exit
	main ENDP
	END main