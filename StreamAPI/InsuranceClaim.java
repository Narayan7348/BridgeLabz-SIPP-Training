import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;
    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) claims.add(new Claim(sc.next(), sc.nextDouble()));
        Map<String, Double> result = claims.stream()
            .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));
        result.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
