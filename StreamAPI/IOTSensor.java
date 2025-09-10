import java.util.*;

public class IoTSensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> readings = new ArrayList<>();
        int n = sc.nextInt();
        int threshold = sc.nextInt();
        for(int i=0;i<n;i++) readings.add(sc.nextInt());
        readings.stream().filter(r -> r > threshold).forEach(System.out::println);
    }
}

