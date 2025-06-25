package oops_day_03_package;

public class Vehicle {
	
	   // Static variable
	   private static double registrationFee = 1000.0; 
	   
	   // Instance variable
	   private final String registrationNumber; // Final variable
	   
	   private String ownerName;
	   private String vehicleType;
	   
	   // Constructor
	   public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
	       this.ownerName = ownerName;
	       this.vehicleType = vehicleType;
	       this.registrationNumber = registrationNumber;
	   }
	   
	   // Static method to update the registration fee
	   public static void updateRegistrationFee(double newFee) {
	       if (newFee >= 0.0) {
	           registrationFee = newFee;
	       } else {
	           System.out.println("Invalid registration fee. Enter a valid fee ");
	       }
	   }
	   
	   // Method to display vehicle registration details
	   public void displayRegistrationDetails() {
	       if (this instanceof Vehicle) {
	           System.out.println("Owner Name: " + ownerName);
	           System.out.println("Vehicle Type: " + vehicleType);
	           System.out.println("Registration Number: " + registrationNumber);
	           System.out.println("Registration Fee: Rs" + registrationFee);
	       } else {
	           System.out.println("The object is not an instance of the Vehicle class");
	       }
	   }
	   
	   // Getters for instance variable
	   public String getOwnerName() {
	       return ownerName;
	   }
	   public String getVehicleType() {
	       return vehicleType;
	   }
	   public String getRegistrationNumber() {
	       return registrationNumber;
	   }
	   
	   //Main Method
	   public static void main(String[] args) {
	       
	       Vehicle.updateRegistrationFee(1500.0); 
	       
	       Vehicle vehicle1 = new Vehicle("Ravi Singh", "Scorpio", "12345");
	       Vehicle vehicle2 = new Vehicle("Rohit Sharma", "Thar", "67890");
	       
	       vehicle1.displayRegistrationDetails();
	       System.out.println();
	       vehicle2.displayRegistrationDetails();
	   }
	}

