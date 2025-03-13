public class Student {
    // Private attributes
    private String name;
    private int id;
    private float[] marks;

    // Constructor
    public Student(String name, int id, float[] marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    // Method to calculate average marks
    public float getAverageMarks() {
        float total = 0;
        for (float mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }

    // Method to print student details
    public void printStudentDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student ID: " + this.id);
        System.out.println("Average Marks: " + getAverageMarks());
    }

    // Method to check if student has passed all subjects
    public boolean isPassing() {
        for (float mark : marks) {
            if (mark < 50) {
                return false;
            }
        }
        return true;
    }

    // Static Method to find and dispaly the details of the student with the highest average marks
    public static Student findTopScorer(Student[] students) {
        Student topScorer = students[0];
        for (Student student : students) {
            if (student.getAverageMarks() > topScorer.getAverageMarks()) {
                topScorer = student;
            }
        }
        System.out.println("\nTop Scorer: ");
        topScorer.printStudentDetails();
        return topScorer;
    }
    
    // Getters for the ID
    public int getId() {
        return id;
    }
}