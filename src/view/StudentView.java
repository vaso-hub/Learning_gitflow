package view;

import controller.StudentController;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private StudentController controller;
    private Scanner scanner;

    public StudentView() {
        controller = new StudentController();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    searchStudentById();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }//end displayMenu

    private void addStudent() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter courses (comma separated): ");
        String coursesInput = scanner.nextLine();
        List<String> courses = List.of(coursesInput.split(","));

        Student student = new Student(firstName, lastName, dateOfBirth, email, courses);
        controller.addStudent(student);
        System.out.println("Student added successfully.");
    }//ebd addStudent

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        Student student = controller.searchStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }//updateStudent

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new courses (comma separated): ");
        String coursesInput = scanner.nextLine();
        List<String> courses = List.of(coursesInput.split(","));

        Student updatedStudent = new Student(firstName, lastName, dateOfBirth, email, courses);
        controller.updateStudent(id, updatedStudent);
        System.out.println("Student updated successfully.");
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        controller.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }//end deleteStudent

    private void viewAllStudents() {
        List<Student> students = controller.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }// end viewAllStudents
    
}
