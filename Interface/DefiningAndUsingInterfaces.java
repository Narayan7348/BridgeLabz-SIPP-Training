import java.util.*;
import java.util.function.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

// Defining and Implementing Interfaces
interface DeviceControl {
    void turnOn();
    void turnOff();
}
class Light implements DeviceControl {
    public void turnOn(){System.out.println("Light ON");}
    public void turnOff(){System.out.println("Light OFF");}
}
class AC implements DeviceControl {
    public void turnOn(){System.out.println("AC ON");}
    public void turnOff(){System.out.println("AC OFF");}
}
class TV implements DeviceControl {
    public void turnOn(){System.out.println("TV ON");}
    public void turnOff(){System.out.println("TV OFF");}
}

interface VehicleRental {
    void rent();
    void returnVehicle();
}
class Car implements VehicleRental {
    public void rent(){System.out.println("Car Rented");}
    public void returnVehicle(){System.out.println("Car Returned");}
}
class Bike implements VehicleRental {
    public void rent(){System.out.println("Bike Rented");}
    public void returnVehicle(){System.out.println("Bike Returned");}
}
class Bus implements VehicleRental {
    public void rent(){System.out.println("Bus Rented");}
    public void returnVehicle(){System.out.println("Bus Returned");}
}

interface Payment {
    void pay(double amount);
}
class UPI implements Payment {
    public void pay(double amount){System.out.println("Paid via UPI: "+amount);}
}
class CreditCard implements Payment {
    public void pay(double amount){System.out.println("Paid via Credit Card: "+amount);}
}
class Wallet implements Payment {
    public void pay(double amount){System.out.println("Paid via Wallet: "+amount);}
}

// Functional Interfaces
class FunctionalExamples {
    static void temperatureAlert() {
        Predicate<Double> alert = t -> t > 37.5;
        System.out.println(alert.test(38.0));
    }
    static void stringLengthChecker() {
        Function<String,Integer> func = s -> s.length();
        System.out.println(func.apply("Hello World"));
    }
    static void backgroundJob() {
        Runnable job = () -> System.out.println("Job Executed");
        new Thread(job).start();
    }
}

// Static Methods in Interfaces
interface SecurityUtils {
    static boolean validatePassword(String pwd) {
        return pwd.length() >= 8 && pwd.matches(".*[0-9].*");
    }
}
interface UnitConverter {
    static double kmToMiles(double km){return km*0.621371;}
    static double kgToLbs(double kg){return kg*2.20462;}
}
interface DateUtils {
    static String formatDate(LocalDate date,String pattern){
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

// Default Methods in Interfaces
interface PaymentProcessor {
    void process(double amount);
    default void refund(double amount){System.out.println("Refunded: "+amount);}
}
class PayPal implements PaymentProcessor {
    public void process(double amount){System.out.println("Processed by PayPal: "+amount);}
}
interface ReportExporter {
    void export();
    default void exportToJSON(){System.out.println("Exported JSON");}
}
class CSVExporter implements ReportExporter {
    public void export(){System.out.println("Exported CSV");}
}
class PDFExporter implements ReportExporter {
    public void export(){System.out.println("Exported PDF");}
}
interface Vehicle {
    void displaySpeed();
    default void displayBattery(){System.out.println("Battery: 80%");}
}
class ElectricCar implements Vehicle {
    public void displaySpeed(){System.out.println("Speed: 120 km/h");}
}
class PetrolCar implements Vehicle {
    public void displaySpeed(){System.out.println("Speed: 100 km/h");}
}

// Marker Interfaces
interface BackupSerializable {}
class EmployeeData implements BackupSerializable {}
class Prototype implements Cloneable {
    int id;
    Prototype(int id){this.id=id;}
    public Object clone() throws CloneNotSupportedException {return super.clone();}
}
interface SensitiveData {}
class BankDetails implements SensitiveData {}

public class DefiningAndUsingInterfaces {
    public static void main(String[] args) throws Exception {
        DeviceControl d=new Light();d.turnOn();d.turnOff();
        VehicleRental v=new Car();v.rent();v.returnVehicle();
        Payment p=new UPI();p.pay(500);

        FunctionalExamples.temperatureAlert();
        FunctionalExamples.stringLengthChecker();
        FunctionalExamples.backgroundJob();

        System.out.println(SecurityUtils.validatePassword("pass1234"));
        System.out.println(UnitConverter.kmToMiles(10));
        System.out.println(UnitConverter.kgToLbs(5));
        System.out.println(DateUtils.formatDate(LocalDate.now(),"dd/MM/yyyy"));

        PaymentProcessor pp=new PayPal();pp.process(2000);pp.refund(500);
        ReportExporter re=new CSVExporter();re.export();re.exportToJSON();
        Vehicle e=new ElectricCar();e.displaySpeed();e.displayBattery();
        Vehicle pCar=new PetrolCar();pCar.displaySpeed();

        Prototype proto=new Prototype(1);
        Prototype copy=(Prototype)proto.clone();
        System.out.println("Cloned ID: "+copy.id);
    }
}

