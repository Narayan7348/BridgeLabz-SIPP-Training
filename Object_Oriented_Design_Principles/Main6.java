import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println(name + " is consulting " + p.name);
    }
}

class Hospital {
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void addPatient(Patient p) {
        patients.add(p);
    }
}

public class Main6 {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor d1 = new Doctor("Dr. Ray");
        Patient p1 = new Patient("Tom");

        hospital.addDoctor(d1);
        hospital.addPatient(p1);

        d1.consult(p1);
    }
}

