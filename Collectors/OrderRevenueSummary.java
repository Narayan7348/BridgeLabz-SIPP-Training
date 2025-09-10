import java.util.*;
import java.util.stream.*;

public class OrderRevenueSummary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Order> orders = new ArrayList<>();
        for(int i=0;i<n;i++){
            String customer = sc.next();
            double amount = sc.nextDouble();
            orders.add(new Order(customer, amount));
        }
        Map<String, Double> revenue = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(Order::getAmount)));
        System.out.println(revenue);
    }
}

class Order {
    private String customer;
    private double amount;
    public Order(String customer,double amount){this.customer=customer;this.amount=amount;}
    public String getCustomer(){return customer;}
    public double getAmount(){return amount;}
}

