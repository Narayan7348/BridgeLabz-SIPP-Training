import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean weekendAvailable;
    Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) doctors.add(new Doctor(sc.next(), sc.next(), sc.nextBoolean()));
        doctors.stream()
               .filter(d -> d.weekendAvailable)
               .sorted(Comparator.comparing(d -> d.specialty))
               .forEach(d -> System.out.println(d.name + " " + d.specialty));
    }
}
