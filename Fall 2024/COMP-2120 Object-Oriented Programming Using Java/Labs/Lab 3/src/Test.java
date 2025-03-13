import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[5]; // Array for 5 Student objects

        // Input for each student
        for (int i = 0; i < students.length; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            // Get name
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            // Get ID with validation
            int id;
            while (true) {
                System.out.print("Enter ID: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt(); // Read the integer ID
                    scanner.nextLine(); // Clear the buffer after reading the integer
                    break; // Valid input, exit loop
                } else {
                    System.out.println("Invalid ID! Please enter a valid integer.\n");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            // Get marks for 3 subjects
            float[] marks = new float[3];
            for (int j = 0; j < marks.length; j++) {
                while (true) {
                    System.out.print("Enter marks for subject " + (j + 1) + ": ");
                    marks[j] = scanner.nextFloat();
                    
                    // Check if marks are valid
                    if (marks[j] >= 0 && marks[j] <= 100) {
                        break; // Valid input, exit loop
                    } else {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.\n");
                    }
                }
            }

            // Create a new Student object and store it in the array
            students[i] = new Student(name, id, marks);

            // Clear the buffer for the next student's name input
            scanner.nextLine();
        }

        // Sort students by average marks in descending order
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                // Compare average marks of two students
                if (students[j].getAverageMarks() < students[j + 1].getAverageMarks()) {
                    // Swap students if the current one has a lower average mark
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // Display the sorted list of students
        System.out.println("\nStudents sorted by average marks (in descending order):");
        for (Student student : students) {
            student.printStudentDetails();
            System.out.println();
        }

        // Search for a student by their ID
        System.out.print("\nEnter the ID of the student to search: ");
        int searchId = scanner.nextInt();
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == searchId) {
                System.out.println("Student found:");
                student.printStudentDetails();
                found = true;
                break;
            }
        }
        // Error message if id not found
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }

        scanner.close();
    }
}