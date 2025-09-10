import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> prices = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) prices.add(sc.nextDouble());
        prices.forEach(System.out::println);
    }
}
