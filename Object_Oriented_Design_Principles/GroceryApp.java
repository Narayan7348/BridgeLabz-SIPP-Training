import java.util.*;

class Product {
    String name;
    double quantity;
    double pricePerUnit;

    Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    double getTotal() {
        return quantity * pricePerUnit;
    }
}

class Customer {
    String name;
    List<Product> products;

    Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }
}

class BillGenerator {
    double generateBill(Customer customer) {
        double total = 0;
        for (Product p : customer.getProducts()) {
            total += p.getTotal();
        }
        return total;
    }
}

// --- Object Diagram Example (Alice, Apples=2kg@$3, Milk=1L@$2) ---
public class GroceryApp {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice");
        alice.addProduct(new Product("Apples", 2, 3));
        alice.addProduct(new Product("Milk", 1, 2));

        BillGenerator billGen = new BillGenerator();
        double totalBill = billGen.generateBill(alice);

        System.out.println("Customer: " + alice.name);
        System.out.println("Total Bill: $" + totalBill);
    }
}

