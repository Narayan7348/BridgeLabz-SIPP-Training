import java.util.*;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println("Name: " + name + ", Price: " + price + ", Category: " + category.getCategoryName());
    }
}

class MarketPlace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product<? extends Category>> catalog = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.print("Enter product type (book/clothing/gadget): ");
            String type = scanner.nextLine().toLowerCase();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (type.equals("book")) {
                catalog.add(new Product<>(name, price, new BookCategory()));
            } else if (type.equals("clothing")) {
                catalog.add(new Product<>(name, price, new ClothingCategory()));
            } else if (type.equals("gadget")) {
                catalog.add(new Product<>(name, price, new GadgetCategory()));
            }
        }

        System.out.print("Enter discount percentage: ");
        double discount = Double.parseDouble(scanner.nextLine());

        for (Product<? extends Category> product : catalog) {
            applyDiscount(product, discount);
        }

        System.out.println("Catalog after discount:");
        for (Product<? extends Category> product : catalog) {
            product.display();
        }
    }
}
