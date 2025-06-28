import java.util.*;
class Flight {
    String flightNumber;
    String origin;
    String destination;

    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination;
    }
}

class Booking {
    String passengerName;
    Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String toString() {
        return "Passenger: " + passengerName + " | " + flight.toString();
    }
}

public class FlightBookingSystem {
    static Flight[] flights = {
        new Flight("AI101", "Delhi", "Mumbai"),
        new Flight("AI102", "Mumbai", "Bangalore"),
        new Flight("AI103", "Delhi", "Chennai"),
        new Flight("AI104", "Bangalore", "Kolkata")
    };

    static List<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchFlights();
                    break;
                case 2:
                    bookFlight();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using Flight Booking System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    public static void searchFlights() {
        System.out.print("Enter origin city: ");
        String origin = scanner.nextLine().toLowerCase();
        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\nAvailable Flights:");
        for (Flight flight : flights) {
            if (flight.origin.toLowerCase().equals(origin) && flight.destination.toLowerCase().equals(destination)) {
                System.out.println(flight);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    public static void bookFlight() {
        System.out.print("Enter flight number to book: ");
        String flightNumber = scanner.nextLine().toUpperCase();
        Flight selectedFlight = null;

        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight != null) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            bookings.add(new Booking(name, selectedFlight));
            System.out.println("Booking successful for " + name + " on " + selectedFlight.flightNumber);
        } else {
            System.out.println("Flight not found.");
        }
    }

    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
        } else {
            System.out.println("\nYour Bookings:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}
