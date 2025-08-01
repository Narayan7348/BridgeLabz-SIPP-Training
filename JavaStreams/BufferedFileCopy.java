import java.io.*;
import java.util.Scanner;

public class BufferedFileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file: ");
        String source = sc.nextLine();
        System.out.print("Enter destination file (buffered): ");
        String destBuffered = sc.nextLine();
        System.out.print("Enter destination file (unbuffered): ");
        String destUnbuffered = sc.nextLine();

        try {
            FileInputStream fis1 = new FileInputStream(source);
            FileOutputStream fos1 = new FileOutputStream(destUnbuffered);
            long start1 = System.nanoTime();
            byte[] buffer1 = new byte[4096];
            int bytesRead1;
            while ((bytesRead1 = fis1.read(buffer1)) != -1) {
                fos1.write(buffer1, 0, bytesRead1);
            }
            fos1.close();
            fis1.close();
            long end1 = System.nanoTime();
            System.out.println("Unbuffered Time (ms): " + (end1 - start1) / 1_000_000);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered));
            long start2 = System.nanoTime();
            byte[] buffer2 = new byte[4096];
            int bytesRead2;
            while ((bytesRead2 = bis.read(buffer2)) != -1) {
                bos.write(buffer2, 0, bytesRead2);
            }
            bos.close();
            bis.close();
            long end2 = System.nanoTime();
            System.out.println("Buffered Time (ms): " + (end2 - start2) / 1_000_000);

        } catch (IOException e) {
            System.out.println("Error occurred during file copy.");
        }
    }
}
