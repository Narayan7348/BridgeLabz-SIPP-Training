package multiple_inheritance_package;

//Person superclass
class Person {
 String name;
 int id;

 // Constructor
 Person(String name, int id) {
     this.name = name;
     this.id = id;
 }

 // Method to display person details
 public void displayInfo() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
 }
}

//Interface representing worker
interface Worker {
 void performDuties();
}

//Chef subclass
class Chef extends Person implements Worker {
 String specialty;

 // Constructor 
 Chef(String name, int id, String specialty) {
     super(name, id); 
     this.specialty = specialty;
 }

 // Method
 public void performDuties() {
     System.out.println("Duties: Indian Meals " + specialty);
 }

 // Display details
 public void displayRole() {
     System.out.println("Role: Chef");
     displayInfo();
     System.out.println("Specialty: " + specialty);
     performDuties();
 }
}

//Waiter subclass
class Waiter extends Person implements Worker {
 int tableCount;

 // Constructor
 Waiter(String name, int id, int tableCount) {
     super(name, id);
     this.tableCount = tableCount;
 }

 // Method
 public void performDuties() {
     System.out.println("Duties: Serves food to " + tableCount + " tables");
 }

 // Display details
 public void displayRole() {
     System.out.println("Role: Waiter");
     displayInfo();
     System.out.println("Tables Assigned: " + tableCount);
     performDuties();
 }
}

//Main Method
public class RestaurantManagement {
 public static void main(String[] args) {
     Chef chef = new Chef("Sanjeev Kapoor", 1, "Indian Cuisine");
     Waiter waiter = new Waiter("Ravi Kumar", 2, 5);

     System.out.println("CHEF");
     chef.displayRole();

     System.out.println("\nWAITER");
     waiter.displayRole();
 }
}

