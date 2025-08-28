import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name; this.price = price; this.rating = rating; this.discount = discount;
    }

    public String toString() {
        return name + " Price:" + price + " Rating:" + rating + " Discount:" + discount;
    }
}

class EcommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Phone", 500, 4.5, 10),
            new Product("Laptop", 1200, 4.8, 15),
            new Product("Tablet", 300, 4.2, 20)
        );

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);
    }
}
