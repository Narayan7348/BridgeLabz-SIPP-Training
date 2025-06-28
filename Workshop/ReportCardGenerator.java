import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    String name;
    String[] subjects;
    int[] marks;

    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        if (subjects.length != marks.length) {
            throw new IllegalArgumentException("Subjects and marks count must match.");
        }
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark: " + mark);
            }
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String assignGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }

    public void displayReportCard() {
        System.out.println("\nReport Card for: " + name);
        System.out.println("----------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        double avg = calculateAverage();
        String grade = assignGrade(avg);
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------\n");
    }
}

public class ReportCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < studentCount; i++) {
            try {
                System.out.print("\nEnter name of student " + (i + 1) + ": ");
                String name = scanner.nextLine();

                System.out.print("Enter number of subjects: ");
                int subjectCount = scanner.nextInt();
                scanner.nextLine(); 

                String[] subjects = new String[subjectCount];
                int[] marks = new int[subjectCount];

                for (int j = 0; j < subjectCount; j++) {
                    System.out.print("Enter name of subject " + (j + 1) + ": ");
                    subjects[j] = scanner.nextLine();

                    System.out.print("Enter mark for " + subjects[j] + ": ");
                    marks[j] = scanner.nextInt();
                    scanner.nextLine(); 
                }

                Student student = new Student(name, subjects, marks);
                students.add(student);

            } catch (InvalidMarkException e) {
                System.out.println("Error: " + e.getMessage());
                i--; 
            }
        }

        
        for (Student student : students) {
            student.displayReportCard();
        }

        
    }
}

