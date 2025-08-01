import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                String data = "Hello from Writer Thread!";
                pos.write(data.getBytes());
                pos.close();
            } catch (IOException e) {
                System.out.println("Writer error");
            }
        });

        Thread reader = new Thread(() -> {
            try {
                int byteData;
                while ((byteData = pis.read()) != -1) {
                    System.out.print((char) byteData);
                }
                pis.close();
            } catch (IOException e) {
                System.out.println("Reader error");
            }
        });

        writer.start();
        reader.start();
    }
}
