package multiple_inheritance_package;

//Vehicle superclass
class Vehicle {
 String model;
 int maxSpeed;

 // Constructor 
 Vehicle(String model, int maxSpeed) {
     this.model = model;
     this.maxSpeed = maxSpeed;
 }

 // Method to display vehicle info
 public void displayInfo() {
     System.out.println("Model: " + model);
     System.out.println("Max Speed: " + maxSpeed + " km/h");
 }
}

//Interface representing refuelable 
interface Refuelable {
 void refuel(); 
}

//ElectricVehicle subclass
class ElectricVehicle extends Vehicle {

 // Constructor
 ElectricVehicle(String model, int maxSpeed) {
     super(model, maxSpeed); 
 }

 // Method 
 public void charge() {
     System.out.println("Charging");
 }

 // Display full information
 public void displayElectricVehicle() {
     System.out.println("Vehicle Type: Electric Vehicle");
     displayInfo();
     charge();
 }
}

//PetrolVehicle subclass
class PetrolVehicle extends Vehicle implements Refuelable {

 // Constructor
 PetrolVehicle(String model, int maxSpeed) {
     super(model, maxSpeed);
 }

 //Method
 public void refuel() {
     System.out.println("Refueling");
 }

 // Display full information
 public void displayPetrolVehicle() {
     System.out.println("Vehicle Type: Petrol Vehicle");
     displayInfo();
     refuel();
 }
}

//Main Method
public class VehicleManagement {
 public static void main(String[] args) {
     ElectricVehicle electric = new ElectricVehicle("Tata Curv", 200);
     PetrolVehicle petrol = new PetrolVehicle("Honda City", 180);

     System.out.println("ELECTRIC VEHICLE");
     electric.displayElectricVehicle();

     System.out.println("\nPETROL VEHICLE");
     petrol.displayPetrolVehicle();
 }
}

