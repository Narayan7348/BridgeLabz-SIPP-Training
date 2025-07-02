package hierarchial_inheritance_package;

//Person superclass
class Person {
 String name;
 int age;

 // Constructor
 Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Method to display person information
 public void displayInfo() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

//Teacher subclass
class Teacher extends Person {
 String subject;  // Subject taught

 // Constructor 
 Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 // Method to display details
 public void displayRole() {
     System.out.println("Role: Teacher");
     displayInfo();
     System.out.println("Subject: " + subject);
 }
}

//Student subclass
class Student extends Person {
 String grade; 

 // Constructor
 Student(String name, int age, String grade) {
     super(name, age);
     this.grade = grade;
 }

 // Method to display details
 public void displayRole() {
     System.out.println("Role: Student");
     displayInfo();
     System.out.println("Grade: " + grade);
 }
}

//Staff member
class Staff extends Person {
 String department; 

 // Constructor
 Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 // Method to display details
 public void displayRole() {
     System.out.println("Role: Staff");
     displayInfo();
     System.out.println("Department: " + department);
 }
}

//Main Method
public class SchoolSystem {
 public static void main(String[] args) {
     Teacher teacher = new Teacher("Mrs. Sharma", 40, "Mathematics");
     Student student = new Student("Rahul", 16, "10th Grade");
     Staff staff = new Staff("Mr. Verma", 35, "Administration");

     System.out.println("TEACHER");
     teacher.displayRole();

     System.out.println("\nSTUDENT");
     student.displayRole();

     System.out.println("\nSTAFF");
     staff.displayRole();
 }
}

