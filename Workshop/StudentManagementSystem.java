import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> students = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Search Student by Name");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Name by ID");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. List All Students");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.print("Enter student ID: ");
                String id = sc.nextLine();
                students.put(id, name);
                System.out.println("Student added.");

            } else if (choice == 2) {
                System.out.print("Enter student name to search: ");
                String name = sc.nextLine();
                boolean found = false;

                for (Map.Entry<String, String> entry : students.entrySet()) {
                    if (entry.getValue().equalsIgnoreCase(name)) {
                        System.out.println("Found: ID=" + entry.getKey() + ", Name=" + entry.getValue());
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter student ID to search: ");
                String id = sc.nextLine();
                if (students.containsKey(id)) {
                    System.out.println("Found: ID=" + id + ", Name=" + students.get(id));
                } else {
                    System.out.println("Student not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter student ID to update: ");
                String id = sc.nextLine();
                if (students.containsKey(id)) {
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    students.put(id, newName);
                    System.out.println("Student name updated.");
                } else {
                    System.out.println("Student ID not found.");
                }

            } else if (choice == 5) {
                System.out.print("Enter student ID to delete: ");
                String id = sc.nextLine();
                if (students.containsKey(id)) {
                    students.remove(id);
                    System.out.println("Student deleted.");
                } else {
                    System.out.println("Student ID not found.");
                }

            } else if (choice == 6) {
                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {
                    System.out.println("List of Students:");
                    for (Map.Entry<String, String> entry : students.entrySet()) {
                        System.out.println("ID=" + entry.getKey() + ", Name=" + entry.getValue());
                    }
                }

            } else if (choice == 7) {
                System.out.println("Exiting system.");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
