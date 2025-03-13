import java.io.*;
import java.util.*;

public class StudentDataProcessor {
    public static void main(String[] args) {
        String inputFileName = "/Users/aakankshamandal/Desktop/Folders/University of Windsor/Fall 2024/COMP-2120/Labs/Lab 8/Lab8/src/students.txt";
        String outputFileName = "students_with_avg.txt";

        List<Student> students = readAndDisplayFile(inputFileName);
        if (students == null) return;

        calculateAverageAndWriteToFile(students, outputFileName);
        assignGradesAndUpdateFile(students, outputFileName);
        findTopScorerAndAppendToFile(students, outputFileName);
    }

    static class Student {
        int id;
        String name;
        int marks1, marks2, marks3;
        double average;
        char grade;

        public Student(int id, String name, int marks1, int marks2, int marks3) {
            this.id = id;
            this.name = name;
            this.marks1 = marks1;
            this.marks2 = marks2;
            this.marks3 = marks3;
        }
    }

    // Task 1: Read and display file content
    private static List<Student> readAndDisplayFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Reading file content:");
            String line = br.readLine(); // Skip header
            System.out.println(line);

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split(", ");
                if (parts.length != 5) continue;

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int marks1 = Integer.parseInt(parts[2]);
                int marks2 = Integer.parseInt(parts[3]);
                int marks3 = Integer.parseInt(parts[4]);

                // Validate marks
                if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100) {
                    System.out.println("Invalid marks for student: " + name);
                    continue;
                }

                students.add(new Student(id, name, marks1, marks2, marks3));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return students;
    }

    // Task 2: Calculate average marks and write to new file
    private static void calculateAverageAndWriteToFile(List<Student> students, String outputFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            bw.write("ID, Name, Marks1, Marks2, Marks3, Average\n");
            for (Student student : students) {
                student.average = (student.marks1 + student.marks2 + student.marks3) / 3.0;
                bw.write(String.format("%d, %s, %d, %d, %d, %.2f\n",
                        student.id, student.name, student.marks1, student.marks2, student.marks3, student.average));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Task 3: Assign grades and update file
    private static void assignGradesAndUpdateFile(List<Student> students, String outputFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, false))) {
            bw.write("ID, Name, Marks1, Marks2, Marks3, Average, Grade\n");
            for (Student student : students) {
                student.grade = assignGrade(student.average);
                bw.write(String.format("%d, %s, %d, %d, %d, %.2f, %c\n",
                        student.id, student.name, student.marks1, student.marks2, student.marks3, student.average, student.grade));
            }
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }

    // Helper method to assign grade
    private static char assignGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }

    // Task 4: Find the top scorer and append to file
    private static void findTopScorerAndAppendToFile(List<Student> students, String outputFileName) {
        Student topScorer = students.stream().max(Comparator.comparingDouble(s -> s.average)).orElse(null);
        if (topScorer == null) return;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName, true))) {
            bw.write(String.format("\nTop Scorer: %s, Average Marks: %.2f, Grade: %c\n",
                    topScorer.name, topScorer.average, topScorer.grade));
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}