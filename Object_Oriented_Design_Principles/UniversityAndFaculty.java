import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department2 {
    String deptName;

    Department2(String name) {
        this.deptName = name;
    }
}

class University {
    ArrayList<Department2> departments = new ArrayList<>();
    ArrayList<Faculty> faculties = new ArrayList<>();

    void addDepartment(Department2 d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    void showStructure() {
        System.out.println("Departments:");
        for (Department2 d : departments) {
            System.out.println(" - " + d.deptName);
        }

        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            System.out.println(" - " + f.name);
        }
    }
}

public class  UniversityAndFaculty{
    public static void main(String[] args) {
        University uni = new University();

        uni.addDepartment(new Department2("Engineering"));
        uni.addDepartment(new Department2("Arts"));

        Faculty f1 = new Faculty("Dr. Smith");
        uni.addFaculty(f1);

        uni.showStructure();
    }
}
