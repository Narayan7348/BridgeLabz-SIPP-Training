package inheritance_package;

//Employee superclass
class Employee {
 String name;
 int id;
 double salary;

 // Constructor
 Employee(String name, int id, double salary) {
     this.name = name;
     this.id = id;
     this.salary = salary;
 }

 // Method to display employee details
 public void displayDetails() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
     System.out.println("Salary: " + salary);
 }
}

//Manager subclass
class Manager extends Employee {
 int teamSize;

 Manager(String name, int id, double salary, int teamSize) {
     super(name, id, salary);
     this.teamSize = teamSize;
 }

 // Override displayDetails to include teamSize
 @Override
 public void displayDetails() {
     super.displayDetails(); 
     System.out.println("Team Size: " + teamSize);
 }
}

//Developer subclass
class Developer extends Employee {
 String programmingLanguage;

 Developer(String name, int id, double salary, String programmingLanguage) {
     super(name, id, salary);
     this.programmingLanguage = programmingLanguage;
 }

 // Override displayDetails to include programmingLanguage
 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("Programming Language: " + programmingLanguage);
 }
}

//Intern subclass
class Intern extends Employee {
 String university;

 Intern(String name, int id, double salary, String university) {
     super(name, id, salary);
     this.university = university;
 }

 // Override displayDetails to include university
 @Override
 public void displayDetails() {
     super.displayDetails();
     System.out.println("University: " + university);
 }
}

//Main Method
public class EmployeeManagement {
 public static void main(String[] args) {
     Employee manager = new Manager("Alice", 101, 90000.0, 5);
     Employee developer = new Developer("Bob", 102, 70000.0, "Java");
     Employee intern = new Intern("Charlie", 103, 20000.0, "GLA University");

     System.out.println("Manager Details:");
     manager.displayDetails();

     System.out.println("\nDeveloper Details:");
     developer.displayDetails();

     System.out.println("\nIntern Details:");
     intern.displayDetails();
 }
}

