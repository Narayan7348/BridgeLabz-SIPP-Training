package linked_list_package;

//Node Class
class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;
    
//Constructor
    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

//Singly Linked List
class StudentList {
    private Student head;

    // Add at Beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at End
    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at Specific Position
    public void addAtPosition(int position, int roll, String name, int age, char grade) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bound");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Deleted successfully");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted successfully");
        }
    }

    // Search by Roll Number
    public void searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Display all students
    public void display() {
        if (head == null) {
            System.out.println("No student records");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update grade by Roll Number
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
}

//Main Method
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();

        list.addAtEnd(1, "Rohit", 16, 'A');
        list.addAtBeginning(2, "Ram", 18, 'B');
        list.addAtPosition(2, 3, "Ravi", 17, 'C');
        list.display();

        list.searchByRollNumber(3);
        list.updateGrade(3, 'B');
        list.display();

        list.deleteByRollNumber(2);
        list.display();
    }
}

