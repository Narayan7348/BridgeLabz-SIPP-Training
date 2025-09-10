import java.util.*;
import java.time.*;

public class TransactionLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> transactionIds = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) transactionIds.add(sc.next());
        transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}

