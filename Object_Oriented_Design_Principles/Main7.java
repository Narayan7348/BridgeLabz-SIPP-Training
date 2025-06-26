import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void showProducts() {
        for (Product p : products) {
            System.out.println(" - " + p.name);
        }
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        System.out.println(name + " placed an order:");
        o.showProducts();
    }
}

public class Main7 {
    public static void main(String[] args) {
        Customer c = new Customer("Alice");
        Order o = new Order();

        o.addProduct(new Product("Laptop"));
        o.addProduct(new Product("Phone"));

        c.placeOrder(o);
    }
}
