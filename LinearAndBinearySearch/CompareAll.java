import java.io.*;
import java.util.Scanner;

public class CompareAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        int count = 1000000;
        String word = "hello";

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append(word);
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sbd.append(word);
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("StringBuffer time: " + bufferTime + " ns");
        System.out.println("StringBuilder time: " + builderTime + " ns");

        long startReader1 = System.nanoTime();
        int wordCount1 = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount1 += words.length;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading with FileReader");
        }
        long endReader1 = System.nanoTime();
        long timeReader1 = endReader1 - startReader1;

        long startReader2 = System.nanoTime();
        int wordCount2 = 0;
        try {
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount2 += words.length;
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader");
        }
        long endReader2 = System.nanoTime();
        long timeReader2 = endReader2 - startReader2;

        System.out.println("FileReader word count: " + wordCount1 + ", time: " + timeReader1 + " ns");
        System.out.println("InputStreamReader word count: " + wordCount2 + ", time: " + timeReader2 + " ns");
    }
}

