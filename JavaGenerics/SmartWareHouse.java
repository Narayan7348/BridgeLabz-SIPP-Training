import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
}

public class SmartWareHouse {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        System.out.print("Enter number of electronics: ");
        int eCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < eCount; i++) {
            System.out.print("Enter electronic item name: ");
            electronicsStorage.addItem(new Electronics(scanner.nextLine()));
        }

        System.out.print("Enter number of groceries: ");
        int gCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < gCount; i++) {
            System.out.print("Enter grocery item name: ");
            groceriesStorage.addItem(new Groceries(scanner.nextLine()));
        }

        System.out.print("Enter number of furniture items: ");
        int fCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < fCount; i++) {
            System.out.print("Enter furniture item name: ");
            furnitureStorage.addItem(new Furniture(scanner.nextLine()));
        }

        System.out.println("Electronics:");
        displayItems(electronicsStorage.getItems());

        System.out.println("Groceries:");
        displayItems(groceriesStorage.getItems());

        System.out.println("Furniture:");
        displayItems(furnitureStorage.getItems());
    }
}

