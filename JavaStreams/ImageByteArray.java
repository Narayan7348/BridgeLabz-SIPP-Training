import java.io.*;
import java.util.Scanner;

public class ImageByteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source image file name: ");
        String source = sc.nextLine();
        System.out.print("Enter destination image file name: ");
        String destination = sc.nextLine();

        try {
            FileInputStream fis = new FileInputStream(source);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageData = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            FileOutputStream fos = new FileOutputStream(destination);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bais.close();
            System.out.println("Image copied successfully using byte array.");
        } catch (IOException e) {
            System.out.println("Error handling image file.");
        }
    }
}
