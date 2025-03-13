import java.util.Scanner;

public class Diamond {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        boolean valid_input = false;

        // Loop until we get valid input
        while (!valid_input) {
            // Ask for number
            System.out.print("Enter an odd integer between 1 and 19: ");
            
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();

                // Check if the number is odd and between 1 and 19
                if (row >= 1 && row <= 19 && row % 2 != 0) {
                    valid_input = true;
                } else {
                    System.out.println("Invalid Input! The number must be odd and between 1 and 19.\n");
                }
            } else {
                System.out.println("Invalid Input! Please enter an integer.\n");
                // Clear the invalid input
                scanner.next();
            }
        }

        int mid = row / 2;

        // Printing the first half including the middle row
        for (int i = 0; i <= mid; i++) {
            // Printing the spaces
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // Printing the stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Printing the second half (below the middle row)
        for (int i = mid - 1; i >= 0; i--) {
            // Printing the spaces
            for (int j = 0; j < mid - i; j++) {
                System.out.print(" ");
            }
            // Printing the stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
