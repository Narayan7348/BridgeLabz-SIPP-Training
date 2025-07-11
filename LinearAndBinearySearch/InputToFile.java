import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filename);
            String line;
            while (!(line = br.readLine()).equals("exit")) {
                fw.write(line + "\n");
            }
            fw.close();
            br.close();
            isr.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}

