import java.util.Scanner;

public class CompareBufferBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        System.out.println("StringBuffer time: " + bufferTime + " ns");
        System.out.println("StringBuilder time: " + builderTime + " ns");
    }
}

