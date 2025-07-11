import java.util.*;

public class StringConcatPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] parts = new String[N];
        for (int i = 0; i < N; i++) parts[i] = sc.next();

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) s += parts[i];
        long end = System.nanoTime();
        System.out.println("String: " + (end - start) + " ns");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(parts[i]);
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) + " ns");

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append(parts[i]);
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) + " ns");
    }
}
