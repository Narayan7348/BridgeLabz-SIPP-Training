import java.util.*;
import java.util.stream.*;

public class TransformNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) names.add(sc.next());
        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}
