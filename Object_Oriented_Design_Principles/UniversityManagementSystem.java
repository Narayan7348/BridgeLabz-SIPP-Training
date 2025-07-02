import java.util.*;

class Course2 {
    String name;
    Professor professor;

    Course2(String name) {
        this.name = name;
    }

    void assignProfessor(Professor p) {
        this.professor = p;
    }

    void showProfessor() {
        System.out.println("Course " + name + " taught by " + professor.name);
    }
}

class Student2 {
    String name;
    ArrayList<Course2> courses = new ArrayList<>();

    Student2(String name) {
        this.name = name;
    }

    void enrollCourse(Course2 c) {
        courses.add(c);
    }

    void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course2 c : courses) {
            System.out.println(" - " + c.name);
        }
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student2 s = new Student2("Jake");
        Professor p = new Professor("Prof. Miller");
        Course2 c = new Course2("Physics");

        c.assignProfessor(p);
        s.enrollCourse(c);

        s.showCourses();
        c.showProfessor();
    }
}

