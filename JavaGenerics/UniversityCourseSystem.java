import java.util.*;

abstract class CourseType {
    String courseName;
    CourseType(String courseName) {
        this.courseName = courseName;
    }
    public String toString() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    public void addCourse(T course) {
        courseList.add(course);
    }
    public List<T> getCourses() {
        return courseList;
    }
}

public class UniversityCourseSystem {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        System.out.print("Enter number of exam-based courses: ");
        int eCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < eCount; i++) {
            System.out.print("Enter exam course name: ");
            examCourses.addCourse(new ExamCourse(scanner.nextLine()));
        }

        System.out.print("Enter number of assignment-based courses: ");
        int aCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < aCount; i++) {
            System.out.print("Enter assignment course name: ");
            assignmentCourses.addCourse(new AssignmentCourse(scanner.nextLine()));
        }

        System.out.print("Enter number of research-based courses: ");
        int rCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rCount; i++) {
            System.out.print("Enter research course name: ");
            researchCourses.addCourse(new ResearchCourse(scanner.nextLine()));
        }

        System.out.println("Exam-Based Courses:");
        displayCourses(examCourses.getCourses());

        System.out.println("Assignment-Based Courses:");
        displayCourses(assignmentCourses.getCourses());

        System.out.println("Research-Based Courses:");
        displayCourses(researchCourses.getCourses());
    }
}
