import java.io.*;
import java.util.*;

public class Stack2540Array {
    int CAPACITY = 128;
    int top;
    String[] stack;
    
    final static String[] valid = {
        "( ) ( ( ) ) {( [ ( ) ] ) } ",
        "(3) (3 + (4 - 5) ) {( [ ( ) ] ) } ",
        "((()(()){([()])}))",
        "[(5+x)-(y+z)]"
    };

    final static String[] invalid = {
        ")(()){([()])}",
        "({[])}",
        "("
    };

    public static void main(String[] args) {
        // Check valid strings
        System.out.println("Valid Expressions:");
        for (String expr : valid) {
            System.out.println(expr + " -> " + isMatched(expr));
        }

        // Check invalid strings
        System.out.println("\nInvalid Expressions:");
        for (String expr : invalid) {
            System.out.println(expr + " -> " + isMatched(expr));
        }

        // Test reverse
        try {
            String[] reversedWords = reverse("Test Data Files/test.txt"); // Use the sample text file
            for (String word : reversedWords) {
                System.out.print(word + " "); // Print the reversed words
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public Stack2540Array() {
        stack = new String[CAPACITY];
        top = -1;
    }

    public void printstack(){
        for(int i = 0; i< size(); i++){
            System.out.println(pop());
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public String top() {
        if (top == -1) {
            return null;
        }
        return stack[top];
    }

    public void push(String element) {
        top++;
        stack[top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String element = stack[top];
        top--;
        return element;
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack2540Array buffer = new Stack2540Array();
        for (char ch : expression.toCharArray()) {
            if (opening.indexOf(ch) != -1) {
                buffer.push(String.valueOf(ch));
            } else if (closing.indexOf(ch) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                char top = buffer.pop().charAt(0);
                if (opening.indexOf(top) != closing.indexOf(ch)) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    static String[] reverse(String filename) throws Exception{
		Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
		Stack2540Array stack = new Stack2540Array();
		while (scanner.hasNext())
			stack.push(scanner.next().toLowerCase());
		String[] rev = new String[stack.size()];
		int i = 0;
        while (!stack.isEmpty()) {
            rev[i++] = stack.pop();
        }
		return rev;
	}
}