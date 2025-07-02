import java.util.*;

class Course {
    String name;
    ArrayList<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void enrollStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("Course: " + name);
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course c) {
        courses.add(c);
        c.enrollStudent(this);
    }

    void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) {
            System.out.println(" - " + c.name);
        }
    }
}

class School {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolAndCourse {
    public static void main(String[] args) {
        School school = new School();

        Student s1 = new Student("Mike");
        Student s2 = new Student("Anna");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c2);

        school.addStudent(s1);
        school.addStudent(s2);

        s1.showCourses();
        s2.showCourses();

        c1.showStudents();
        c2.showStudents();
    }
}

