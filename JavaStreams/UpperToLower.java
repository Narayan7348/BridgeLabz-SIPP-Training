import java.io.*;
import java.util.Scanner;

public class UpperToLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source text file: ");
        String source = sc.nextLine();
        System.out.print("Enter destination text file: ");
        String destination = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destination));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            br.close();
            bw.close();
            System.out.println("File converted to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("Error during file processing.");
        }
    }
}
