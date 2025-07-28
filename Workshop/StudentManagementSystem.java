import java.util.*;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, String> students = new HashMap<>();
        while(true){
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by Name");
            System.out.println("3. List All Students");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if(choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.print("Enter student ID: ");
                String id = sc.nextLine();
                students.put(id, name);
            } else if(choice == 2) {
                System.out.print("Enter student name to search: ");
                String name = sc.nextLine();
                boolean found = false;
                for(Map.Entry<String, String> entry : students.entrySet()) {
                    if(entry.getValue().equalsIgnoreCase(name)) {
                        System.out.println("Found: ID=" + entry.getKey() + ", Name=" + entry.getValue());
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("Student not found.");
                }
            } else if(choice == 3) {
                System.out.println("List of Students:");
                for(Map.Entry<String, String> entry : students.entrySet()) {
                    System.out.println("ID=" + entry.getKey() + ", Name=" + entry.getValue());
                }
            } else if(choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

    }
    
}
