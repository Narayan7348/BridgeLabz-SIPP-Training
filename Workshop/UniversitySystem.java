import java.util.*;
import java.util.ArrayList;
interface Graded {
    void assignGrade(Student student, Course course, String grade);
}

class Course {
    String courseName;
    String courseCode;

    Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }
}

abstract class Student {
    String name;
    int id;
    private double gpa;
    private int totalCredits;

    List<Enrollment> enrollments = new ArrayList<>();

    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
        this.totalCredits = 0;
    }

    public void enroll(Course course) {
        enrollments.add(new Enrollment(this, course));
    }

    public void updateGPA(double gradePoint) {
        totalCredits++;
        gpa = ((gpa * (totalCredits - 1)) + gradePoint) / totalCredits;
    }

    public double getGPA() {
        return gpa;
    }

    public void showTranscript() {
        System.out.println("Transcript for " + name + ":");
        for (Enrollment e : enrollments) {
            System.out.println(e.course.courseName + " - " + e.grade);
        }
        System.out.println("GPA: " + gpa);
    }
}

class Undergraduate extends Student {
    Undergraduate(String name, int id) {
        super(name, id);
    }
}

class Postgraduate extends Student {
    Postgraduate(String name, int id) {
        super(name, id);
    }
}

class Faculty implements Graded {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    public void assignGrade(Student student, Course course, String grade) {
        for (Enrollment e : student.enrollments) {
            if (e.course.courseCode.equals(course.courseCode)) {
                e.grade = grade;
                double gradePoint = 0;
                if (grade.equals("A")) gradePoint = 4.0;
                else if (grade.equals("B")) gradePoint = 3.0;
                else if (grade.equals("C")) gradePoint = 2.0;
                else if (grade.equals("D")) gradePoint = 1.0;
                else if (grade.equals("F")) gradePoint = 0.0;
                else if (grade.equals("P")) gradePoint = 4.0;
                else if (grade.equals("F")) gradePoint = 0.0;
                student.updateGPA(gradePoint);
                break;
            }
        }
    }
}

class Enrollment {
    Student student;
    Course course;
    String grade = "Not Assigned";

    Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Type (UG/PG):");
        String type = sc.nextLine();

        System.out.println("Enter Student Name:");
        String studentName = sc.nextLine();

        System.out.println("Enter Student ID:");
        int studentId = sc.nextInt();
        sc.nextLine();

        Student student;
        if (type.equalsIgnoreCase("UG")) {
            student = new Undergraduate(studentName, studentId);
        } else {
            student = new Postgraduate(studentName, studentId);
        }

        System.out.println("Enter Course Name:");
        String courseName = sc.nextLine();

        System.out.println("Enter Course Code:");
        String courseCode = sc.nextLine();

        Course course = new Course(courseName, courseCode);
        student.enroll(course);

        System.out.println("Enter Faculty Name:");
        String facultyName = sc.nextLine();
        Faculty faculty = new Faculty(facultyName);

        System.out.println("Enter Grade to Assign (A/B/C/D/F or P/F):");
        String grade = sc.nextLine();

        faculty.assignGrade(student, course, grade);

        student.showTranscript();
    }
}
