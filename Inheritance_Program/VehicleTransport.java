package inheritance_package;

//Vehicle superclass
class Vehicle {
 int maxSpeed;         
 String fuelType;     

 // Constructor
 Vehicle(int maxSpeed, String fuelType) {
     this.maxSpeed = maxSpeed;
     this.fuelType = fuelType;
 }

 // Method to display vehicle information
 public void displayInfo() {
     System.out.println("Max Speed: " + maxSpeed + " km/h");
     System.out.println("Fuel Type: " + fuelType);
 }
}

//Car subclass
class Car extends Vehicle {
 int seatCapacity;   

 // Constructor
 Car(int maxSpeed, String fuelType, int seatCapacity) {
     super(maxSpeed, fuelType);      
     this.seatCapacity = seatCapacity;
 }

 // Overriding display information to add seat capacity
 @Override
 public void displayInfo() {
     super.displayInfo();            
     System.out.println("Seat Capacity: " + seatCapacity);
 }
}

//Truck subclass
class Truck extends Vehicle {
 int loadCapacity;    

 // Constructor
 Truck(int maxSpeed, String fuelType, int loadCapacity) {
     super(maxSpeed, fuelType);
     this.loadCapacity = loadCapacity;
 }

 // Overriding display information to add load capacity
 @Override
 public void displayInfo() {
     super.displayInfo();
     System.out.println("Load Capacity: " + loadCapacity + " kg");
 }
}

//Motorcycle subclass
class Motorcycle extends Vehicle {
 boolean hasCarrier;   

 // Constructor
 Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
     super(maxSpeed, fuelType);
     this.hasCarrier = hasCarrier;
 }

 // Overriding display infomation to show carrier
 @Override
 public void displayInfo() {
     super.displayInfo();
     System.out.println("Has Carrier: " + (hasCarrier ? "Yes" : "No"));
 }
}

//Main Method
public class VehicleTransport {
 public static void main(String[] args) {
     Vehicle[] vehicles = new Vehicle[3];

     vehicles[0] = new Car(180, "Petrol", 5);                 
     vehicles[1] = new Truck(120, "Diesel", 5000);            
     vehicles[2] = new Motorcycle(150, "Petrol", true);       

     for (int i = 0; i < vehicles.length; i++) {
         System.out.println("Vehicle " + (i + 1) + " Info:");
         vehicles[i].displayInfo(); 
         System.out.println();
     }
 }
}
