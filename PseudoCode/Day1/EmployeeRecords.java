/*
CLASS Employee
    FIELDS
        name, id, department, salary
    
    CONSTRUCTOR
        initialize all fields

CLASS EmployeeRecords
    PRIVATE FIELD
        ArrayList<Employee> employees
    
    METHOD addEmployee(Employee)
        ADD to ArrayList
    
    METHOD getByDepartment(department)
        USE streams to filter employees by department
        RETURN filtered list
    
    METHOD displayEmployees(List<Employee>)
        USE streams to print employee details

MAIN CLASS
    CREATE EmployeeRecords object
    ADD various employees
    TEST filtering by department
*/