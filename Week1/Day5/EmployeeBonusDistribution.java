/*class Employee {
    String name;
    String dept;
    int rating;
    double salary;
}

main() {
    List<Employee> employees = ...

    // Step 1: Group by department
    Map<String, List<Employee>> deptWise = groupByDept(employees);

    // Step 2: For each department
    for(dept : deptWise) {
        List<Employee> emps = deptWise[dept];

        double totalSalary = sum(emps.salary);
        double bonusPool = totalSalary * 0.10;

        int totalRating = sum(emps.rating);

        for(emp in emps) {
            double share = (emp.rating / totalRating) * bonusPool;
            print(emp.name + " gets bonus: " + share);
        }
    }
}
*/