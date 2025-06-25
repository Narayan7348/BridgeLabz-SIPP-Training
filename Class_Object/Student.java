


public class Student {
   
    String name;
    int rollNumber;
    double marks;
    String grade;

    
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.grade = calculateGrade(); 
    }

    
    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    
    public void displayDetails() {
        System.out.println("Student Report:");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + grade);
    }

   
    public static void main(String[] args) {
        
        Student s1 = new Student("Manish", 101, 88.5);

        
        s1.displayDetails();
    }
}
