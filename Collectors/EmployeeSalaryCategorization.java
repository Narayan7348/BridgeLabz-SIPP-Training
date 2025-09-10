import java.util.*;
import java.util.stream.*;

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for(int i=0;i<n;i++){
            String name = sc.next();
            String dept = sc.next();
            double salary = sc.nextDouble();
            employees.add(new Employee(name, dept, salary));
        }
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;
    public Employee(String name,String department,double salary){this.name=name;this.department=department;this.salary=salary;}
    public String getDepartment(){return department;}
    public double getSalary(){return salary;}
}
