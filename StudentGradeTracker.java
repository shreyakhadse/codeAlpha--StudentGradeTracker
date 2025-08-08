import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String name;
    double grade;
    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {

            boolean running = true;

        System.out.println("=== Student Grade Tracker===");

        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showReport();
                case 3 -> {
                    running = false;
                    System.out.println("Exiting program.");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    
}



    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade (0 - 100): ");
        double grade = getDoubleInput();

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Must be between 0 and 100.");
            return;
        }

        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    private static void showReport() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        String highestStudent = "", lowestStudent = "";

        System.out.println("\n--- Student Report ---");
        for (Student s : students) {
            System.out.printf("Name: %-20s Grade: %.2f%n", s.name, s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                highestStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.printf("%nAverage Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f (%s)%n", highest, highestStudent);
        System.out.printf("Lowest Grade:  %.2f (%s)%n", lowest, lowestStudent);
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid integer: ");
            scanner.nextLine();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return val;
    }

    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        double val = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return val;
    }

}
