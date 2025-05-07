import java.io.*;
import java.util.*;

public class Stack2540ArrayDynamic {
    private int CAPACITY = 4; // Start with a small size
    private int top;
    private String[] stack;

    public Stack2540ArrayDynamic() {
        stack = new String[CAPACITY];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public String top() {
        if (top == -1) return null;
        return stack[top];
    }

    public void push(String element) {
        if (top + 1 == CAPACITY) {
            resize(2 * CAPACITY); // Double the capacity
            //resize(CAPACITY + 128); // Increase capacity by 128
        }
        stack[++top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            return null; // Stack underflow
        }
        String result = stack[top--];

        // Shrink if stack is less than 1/12 full
        if (size() > 0 && size() == CAPACITY / 12) {
            resize(CAPACITY / 4);
        }
        return result;
    }

    private void resize(int newCapacity) {
        stack = Arrays.copyOf(stack, newCapacity);
        CAPACITY = newCapacity;
        // String[] newStack = new String[newCapacity];
        // for (int i = 0; i <= top; i++) {
        //     newStack[i] = stack[i];
        // }
        // stack = newStack;
        // CAPACITY = newCapacity;
    }

    static String[] reverseDynamic(String filename) throws Exception {
        // Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
        // Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic();
    
        // while (scanner.hasNext()) {
        //     stack.push(scanner.next().toLowerCase());
        // }
        // scanner.close();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Stack2540ArrayDynamic stack = new Stack2540ArrayDynamic();
        String line;
        
        while ((line = reader.readLine()) != null) {
            for (String word : line.split("[^a-zA-Z]+")) {
                if (!word.isEmpty()) {
                    stack.push(word.toLowerCase());
                }
            }
        }
        reader.close();
    
        String[] rev = new String[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            rev[i++] = stack.pop();
        }
        return rev;
    }
    

    public static void main(String[] args) throws Exception {
        // List of files to test
        String PATH = "Test Data Files/dblp";
        String[] DATASETS = { "200", "400","800","1600","3200","6400", "10000","20000","40000", "80000","160000", "320000", "640000", "1280000", "2560000", "1m", "3m"};//, "10k","100k"}; //, "5k", "10k", "100k", "1m", "" };
        
        for (String dataset : DATASETS) {
            String filename = PATH + dataset + ".txt";
            // Run the reverseDynamic method
            System.out.println("Running on file: " + filename );
            long startTime = System.currentTimeMillis();
            reverseDynamic(filename);
            long endTime = System.currentTimeMillis();
			String time = String.format("%12d", endTime - startTime);
            System.out.println("TIme: " + time);
        }
    }
}