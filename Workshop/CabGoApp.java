import java.util.Scanner;

interface IRideService {
    void bookRide(double distance);
    void endRide();
}

class Vehicle {
    String vehicleNumber;
    int capacity;
    String type;

    Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    double calculateFare(double distance) {
        return 0;
    }
}

class Mini extends Vehicle {
    Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini");
    }

    double calculateFare(double distance) {
        return 50 + distance * 8;
    }
}

class Sedan extends Vehicle {
    Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan");
    }

    double calculateFare(double distance) {
        return 60 + distance * 10;
    }
}

class SUV extends Vehicle {
    SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV");
    }

    double calculateFare(double distance) {
        return 80 + distance * 15;
    }
}

class Driver {
    String name;
    String licenseNumber;
    private double rating;

    Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

class Ride implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private double fare;

    Ride(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    public void bookRide(double distance) {
        fare = vehicle.calculateFare(distance);
        System.out.println("Ride booked with " + vehicle.type);
        System.out.println("Driver: " + driver.name + ", Rating: " + driver.getRating());
        System.out.println("Fare: " + fare);
    }

    public void endRide() {
        System.out.println("Ride ended. Please pay: " + fare);
    }
}

public class CabGoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter driver name:");
        String name = sc.nextLine();
        System.out.println("Enter license number:");
        String license = sc.nextLine();
        System.out.println("Enter rating:");
        double rating = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose vehicle type (Mini/Sedan/SUV):");
        String type = sc.nextLine();
        System.out.println("Enter vehicle number:");
        String vehicleNumber = sc.nextLine();

        Vehicle vehicle;
        if (type.equalsIgnoreCase("Mini")) {
            vehicle = new Mini(vehicleNumber);
        } else if (type.equalsIgnoreCase("Sedan")) {
            vehicle = new Sedan(vehicleNumber);
        } else {
            vehicle = new SUV(vehicleNumber);
        }

        Driver driver = new Driver(name, license, rating);
        Ride ride = new Ride(vehicle, driver);

        System.out.println("Enter distance in km:");
        double distance = sc.nextDouble();

        ride.bookRide(distance);
        ride.endRide();
    }
}

