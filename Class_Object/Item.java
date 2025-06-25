


public class Item {
    
    int itemCode;
    String itemName;
    double price;

    
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

   
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: ₹" + price);
    }

    
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

   
    public static void main(String[] args) {
     
        Item item1 = new Item(101, "Notebook", 45.50);

        
        item1.displayItemDetails();

        
        int quantity = 4;
        double totalCost = item1.calculateTotalCost(quantity);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + totalCost);
    }
}

