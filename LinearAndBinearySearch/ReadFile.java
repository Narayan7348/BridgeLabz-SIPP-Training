import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

