import java.io.*;
import java.util.Scanner;

public class ErrorLineReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter large text file name: ");
        String fileName = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

