import java.io.*;
import java.util.Scanner;

public class StudentDataStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"));
            System.out.print("Enter number of students: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.print("Enter Roll Number: ");
                int roll = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter GPA: ");
                float gpa = Float.parseFloat(sc.nextLine());

                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }
            dos.close();
            System.out.println("Student data saved.");

            DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"));
            System.out.println("\nReading student data from file:");
            for (int i = 0; i < n; i++) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
            dis.close();

        } catch (IOException e) {
            System.out.println("Error occurred during file operation.");
        }
    }
}
