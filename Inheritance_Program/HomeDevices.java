package single_inheritance_package;

//Device superclass
class Device {
 String deviceId;   
 String status;      

 // Constructor
 Device(String deviceId, String status) {
     this.deviceId = deviceId;
     this.status = status;
 }

 // Method to display device status
 public void displayStatus() {
     System.out.println("Device ID: " + deviceId);
     System.out.println("Status: " + status);
 }
}

//Thermostat subclass 
class Thermostat extends Device {
 double temperatureSetting;  

 Thermostat(String deviceId, String status, double temperatureSetting) {
     super(deviceId, status); 
     this.temperatureSetting = temperatureSetting;
 }

 // Overriding display status to include temperature setting
 @Override
 public void displayStatus() {
     super.displayStatus();
     System.out.println("Temperature Setting: " + temperatureSetting + " Degree Celsius");
 }
}

//Main Method
public class HomeDevices {
 public static void main(String[] args) {
     Thermostat thermostat = new Thermostat("123", "ON", 22.5);

     System.out.println("Smart Device Status:");
     thermostat.displayStatus();
 }
}

