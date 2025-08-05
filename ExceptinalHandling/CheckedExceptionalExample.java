import java.io.*;
import java.util.Scanner;

public class CheckedExceptionalExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
