import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        long start = System.nanoTime();
        FileReader fr = new FileReader(filename);
        while (fr.read() != -1) {}
        fr.close();
        long end = System.nanoTime();
        System.out.println("FileReader: " + (end - start) + " ns");

        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
        while (isr.read() != -1) {}
        isr.close();
        end = System.nanoTime();
        System.out.println("InputStreamReader: " + (end - start) + " ns");
    }
}
