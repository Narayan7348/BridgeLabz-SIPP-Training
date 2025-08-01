import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            employees.add(new Employee(id, name, dept, salary));
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"));
            oos.writeObject(employees);
            oos.close();
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees.");
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            List<Employee> readList = (List<Employee>) ois.readObject();
            ois.close();
            System.out.println("Employees from file:");
            for (Employee emp : readList) {
                System.out.println(emp.id + " " + emp.name + " " + emp.department + " " + emp.salary);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees.");
        }
    }
}

