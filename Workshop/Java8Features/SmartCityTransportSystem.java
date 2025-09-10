import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// ============================ MAIN CLASS ============================
public class SmartCityTransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial transport services
        List<TransportService> services = new ArrayList<>();
        services.add(new BusService("B100", "Central", "North", 50.0, true));
        services.add(new MetroService("M1", "Central", "East", 30.0, true));
        services.add(new TaxiService("TAXI-A", "Central", "South", 120.0, false));
        services.add(new TaxiService("AMB-01", "Hospital", "Airport", 0.0, true));

        List<Trip> tripLog = new ArrayList<>();
        boolean running = true;

        System.out.println("Welcome to Smart City Transport & Service Management System");

        while (running) {
            System.out.println("Choose: 1-Book Trip 2-Show Live Dashboard 3-Revenue Report 4-Add Service 5-Exit");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    BookingSystem.bookTrip(sc, services, tripLog);
                    break;
                case "2":
                    Dashboard.showDashboard(services, tripLog);
                    break;
                case "3":
                    ReportGenerator.generateReport(tripLog);
                    break;
                case "4":
                    ServiceManager.addService(sc, services);
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
        System.out.println("Shutting down system.");
    }
}

// ============================ INTERFACES ============================
interface TransportService {
    String getId();
    String getOrigin();
    String getDestination();
    double getFare();
    String getType();

    default void printServiceDetails() {
        System.out.println(toString());
    }

    static double defaultFareEstimate(double distance, double base) {
        return base + distance * 0.45;
    }
}

interface GeoUtils {
    static double calculateDistance(String a, String b) {
        int hash = Math.abs(a.hashCode() - b.hashCode());
        return (hash % 50) + 1;
    }
}

@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, double baseFare);
}

interface EmergencyService {}

// ============================ SERVICE CLASSES ============================
class BusService implements TransportService {
    private String id, origin, destination; private double fare; private boolean active;
    BusService(String id, String origin, String destination, double fare, boolean active){this.id=id;this.origin=origin;this.destination=destination;this.fare=fare;this.active=active;}
    public String getId(){return id;} public String getOrigin(){return origin;} public String getDestination(){return destination;} public double getFare(){return fare;} public String getType(){return "Bus";} public String toString(){return "Bus["+id+"] from "+origin+" to "+destination+" fare:"+fare;}
}

class MetroService implements TransportService {
    private String id, origin, destination; private double fare; private boolean active;
    MetroService(String id, String origin, String destination, double fare, boolean active){this.id=id;this.origin=origin;this.destination=destination;this.fare=fare;this.active=active;}
    public String getId(){return id;} public String getOrigin(){return origin;} public String getDestination(){return destination;} public double getFare(){return fare;} public String getType(){return "Metro";} public String toString(){return "Metro["+id+"] from "+origin+" to "+destination+" fare:"+fare;}
}

class TaxiService implements TransportService, EmergencyService {
    private String id, origin, destination; private double fare; private boolean emergency;
    TaxiService(String id, String origin, String destination, double fare, boolean emergency){this.id=id;this.origin=origin;this.destination=destination;this.fare=fare;this.emergency=emergency;}
    public String getId(){return id;} public String getOrigin(){return origin;} public String getDestination(){return destination;} public double getFare(){return fare;} public String getType(){return emergency?"Ambulance":"Taxi";} public String toString(){return (emergency?"Emergency":"Taxi")+"["+id+"] from "+origin+" to "+destination+" fare:"+fare;}
}

class FerryService implements TransportService {
    private String id, origin, destination; private double fare;
    FerryService(String id, String origin, String destination, double fare){this.id=id;this.origin=origin;this.destination=destination;this.fare=fare;}
    public String getId(){return id;} public String getOrigin(){return origin;} public String getDestination(){return destination;} public double getFare(){return fare;} public String getType(){return "Ferry";} public String toString(){return "Ferry["+id+"] from "+origin+" to "+destination+" fare:"+fare;}
}

// ============================ ENTITY CLASSES ============================
class Trip {
    private String serviceId, type, origin, destination; private int passengers; private double fare; private boolean peak;
    Trip(String serviceId, String type, String origin, String destination, int passengers, double fare, boolean peak){this.serviceId=serviceId;this.type=type;this.origin=origin;this.destination=destination;this.passengers=passengers;this.fare=fare;this.peak=peak;}
    public String getRoute(){return origin+"->"+destination+"("+type+")";} public double getFare(){return fare*passengers;} public boolean isPeak(){return peak;} public String toString(){return "Trip{"+serviceId+","+type+","+origin+"->"+destination+",p="+passengers+",fare="+getFare()+"}";}
}

// ============================ FEATURE CLASSES ============================
class BookingSystem {
    static void bookTrip(Scanner sc, List<TransportService> services, List<Trip> tripLog) {
        System.out.println("Enter origin:");
        String origin = sc.nextLine().trim();
        System.out.println("Enter destination:");
        String destination = sc.nextLine().trim();
        System.out.println("Enter preference: earliest/fare/any");
        String pref = sc.nextLine().trim();

        List<TransportService> available = services.stream()
                .filter(s -> s.getOrigin().equalsIgnoreCase(origin) || s.getOrigin().equalsIgnoreCase("Central"))
                .filter(s -> s.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

        if (available.isEmpty()) {
            System.out.println("No direct services found. Showing all services leaving from origin.");
            available = services.stream().filter(s -> s.getOrigin().equalsIgnoreCase(origin)).collect(Collectors.toList());
        }

        Comparator<TransportService> byFare = Comparator.comparingDouble(TransportService::getFare);
        Comparator<TransportService> byId = Comparator.comparing(TransportService::getId);
        Stream<TransportService> stream = available.stream();
        if (pref.equalsIgnoreCase("fare")) stream = stream.sorted(byFare.thenComparing(byId));
        else stream = stream.sorted(byId);

        List<TransportService> sorted = stream.collect(Collectors.toList());
        System.out.println("Available services:");
        sorted.forEach(TransportService::printServiceDetails);

        if (!sorted.isEmpty()) {
            System.out.println("Select service id to book:");
            String sid = sc.nextLine().trim();
            Optional<TransportService> sel = sorted.stream().filter(s -> s.getId().equalsIgnoreCase(sid)).findFirst();
            if (sel.isPresent()) {
                TransportService s = sel.get();
                System.out.println("Enter number of passengers:");
                int p = Integer.parseInt(sc.nextLine().trim());

                FareCalculator fc = (distance, baseFare) -> baseFare + distance * 0.5;
                double distance = GeoUtils.calculateDistance(origin, destination);
                double fare = fc.calculateFare(distance, s.getFare());

                Trip t = new Trip(s.getId(), s.getType(), origin, destination, p, fare, TimeUtils.isPeakTime());
                tripLog.add(t);
                System.out.println("Booked: " + t);

                if (s instanceof EmergencyService) {
                    System.out.println("This is an emergency service and has been prioritized.");
                }
            } else System.out.println("Invalid service id.");
        }
    }
}

class Dashboard {
    static void showDashboard(List<TransportService> services, List<Trip> tripLog) {
        System.out.println("Live Dashboard - Active Services:");
        services.forEach(TransportService::printServiceDetails);
        System.out.println("Live Trip Feed:");
        tripLog.stream().limit(10).forEach(System.out::println);
    }
}

class ReportGenerator {
    static void generateReport(List<Trip> tripLog) {
        System.out.println("Revenue Report:");

        Map<String, List<Trip>> grouped = tripLog.stream().collect(Collectors.groupingBy(Trip::getRoute));
        grouped.forEach((route, trips) -> {
            DoubleSummaryStatistics stats = trips.stream().collect(Collectors.summarizingDouble(Trip::getFare));
            System.out.println(route + " -> count: " + trips.size() + ", total: " + stats.getSum() + ", avg: " + stats.getAverage());
        });

        Map<Boolean, List<Trip>> peakPartition = tripLog.stream().collect(Collectors.partitioningBy(Trip::isPeak));
        System.out.println("Peak trips: " + peakPartition.get(true).size() + ", Non-peak: " + peakPartition.get(false).size());

        Map<String, Long> topRoutes = tripLog.stream().collect(Collectors.groupingBy(Trip::getRoute, Collectors.counting()));
        topRoutes.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(5).forEach(e -> System.out.println("Top route: " + e.getKey() + " -> " + e.getValue()));
    }
}

class ServiceManager {
    static void addService(Scanner sc, List<TransportService> services) {
        System.out.println("Add service - choose type: 1-Bus 2-Metro 3-Taxi 4-Ferry");
        String ttype = sc.nextLine().trim();
        System.out.println("Enter id:");
        String id = sc.nextLine().trim();
        System.out.println("Enter origin:");
        String o = sc.nextLine().trim();
        System.out.println("Enter destination:");
        String d = sc.nextLine().trim();
        System.out.println("Enter base fare:");
        double bf = Double.parseDouble(sc.nextLine().trim());
        boolean emerg = false;
        if (ttype.equals("3")) {
            System.out.println("Is emergency service? true/false");
            emerg = Boolean.parseBoolean(sc.nextLine().trim());
        }
        switch (ttype) {
            case "1": services.add(new BusService(id, o, d, bf, true)); break;
            case "2": services.add(new MetroService(id, o, d, bf, true)); break;
            case "3": services.add(new TaxiService(id, o, d, bf, emerg)); break;
            default: services.add(new FerryService(id, o, d, bf)); break;
        }
        System.out.println("Service added.");
    }
}

class TimeUtils {
    static boolean isPeakTime(){
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        return h>=7 && h<=10 || h>=17 && h<=20;
    }
}

