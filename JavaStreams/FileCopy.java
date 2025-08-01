import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file name: ");
        String source = sc.nextLine();
        System.out.print("Enter destination file name: ");
        String destination = sc.nextLine();

        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("Error occurred while copying.");
        }
    }
}
