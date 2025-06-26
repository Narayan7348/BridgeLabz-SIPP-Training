import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();

    Department(String deptName) {
        this.deptName = deptName;
    }

    void addEmployee(Employee emp) {
        employees.add(emp);
    }

    void showEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            System.out.println(" - " + e.name);
        }
    }
}

class Company {
    ArrayList<Department> departments = new ArrayList<>();

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void showCompanyStructure() {
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Company company = new Company();
        Department d1 = new Department("HR");
        Department d2 = new Department("IT");

        d1.addEmployee(new Employee("Alice"));
        d2.addEmployee(new Employee("Bob"));

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showCompanyStructure();
    }
}
