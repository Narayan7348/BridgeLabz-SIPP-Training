package linked_list_package;

//Node class 
class Item {
 String name;
 int id;
 int quantity;
 double price;
 Item next;

 // Constructor
 Item(String name, int id, int quantity, double price) {
     this.name = name;
     this.id = id;
     this.quantity = quantity;
     this.price = price;
     this.next = null;
 }
}

//Singly Linked List 
class Inventory {
 Item head = null; 

 // Add item at beginning
 public void addAtBeginning(String name, int id, int qty, double price) {
     Item newItem = new Item(name, id, qty, price);
     newItem.next = head;
     head = newItem;
 }

 // Add item at end
 public void addAtEnd(String name, int id, int qty, double price) {
     Item newItem = new Item(name, id, qty, price);
     if (head == null) {
         head = newItem;
         return;
     }
     Item temp = head;
     while (temp.next != null)
         temp = temp.next;
     temp.next = newItem;
 }

 // Add item at specific position
 public void addAtPosition(String name, int id, int qty, double price, int pos) {
     if (pos == 0) {
         addAtBeginning(name, id, qty, price);
         return;
     }
     Item newItem = new Item(name, id, qty, price);
     Item temp = head;
     for (int i = 0; temp != null && i < pos - 1; i++)
         temp = temp.next;
     if (temp == null) return;  // Invalid position
     newItem.next = temp.next;
     temp.next = newItem;
 }

 // Remove item by ID
 public void removeById(int id) {
     if (head == null) return;
     if (head.id == id) {
         head = head.next;
         return;
     }
     Item temp = head;
     while (temp.next != null && temp.next.id != id)
         temp = temp.next;
     if (temp.next != null)
         temp.next = temp.next.next;
 }

 // Update item quantity
 public void updateQuantity(int id, int newQty) {
     Item temp = head;
     while (temp != null) {
         if (temp.id == id) {
             temp.quantity = newQty;
             return;
         }
         temp = temp.next;
     }
 }

 // Search by item ID
 public void searchById(int id) {
     Item temp = head;
     while (temp != null) {
         if (temp.id == id) {
             System.out.println("Found: " + temp.name + " Qty: " + temp.quantity + " Price: " + temp.price);
             return;
         }
         temp = temp.next;
     }
     System.out.println("Item ID not found");
 }

 // Search by item name
 public void searchByName(String name) {
     Item temp = head;
     while (temp != null) {
         if (temp.name.equalsIgnoreCase(name)) {
             System.out.println("Found: ID: " + temp.id + " Qty: " + temp.quantity + " Price: " + temp.price);
             return;
         }
         temp = temp.next;
     }
     System.out.println("Item Name not found");
 }

 // Calculate total inventory value
 public void totalValue() {
     double total = 0;
     Item temp = head;
     while (temp != null) {
         total += temp.quantity * temp.price;
         temp = temp.next;
     }
     System.out.println("Total Inventory Value: " + total);
 }

 // Sort inventory by name
 public void sortByName(boolean ascending) {
     for (Item i = head; i != null; i = i.next) {
         for (Item j = i.next; j != null; j = j.next) {
             if ((ascending && i.name.compareTo(j.name) > 0) || (!ascending && i.name.compareTo(j.name) < 0)) {
                 swap(i, j);
             }
         }
     }
 }

 // Sort inventory by price
 public void sortByPrice(boolean ascending) {
     for (Item i = head; i != null; i = i.next) {
         for (Item j = i.next; j != null; j = j.next) {
             if ((ascending && i.price > j.price) || (!ascending && i.price < j.price)) {
                 swap(i, j);
             }
         }
     }
 }

 // Utility: Swap node data
 public void swap(Item a, Item b) {
     String tempName = a.name; int tempId = a.id; int tempQty = a.quantity; double tempPrice = a.price;
     a.name = b.name; a.id = b.id; a.quantity = b.quantity; a.price = b.price;
     b.name = tempName; b.id = tempId; b.quantity = tempQty; b.price = tempPrice;
 }

 // Display entire inventory
 public void display() {
     Item temp = head;
     while (temp != null) {
         System.out.println("Name: " + temp.name + " ID: " + temp.id + " Qty: " + temp.quantity + " Price: " + temp.price);
         temp = temp.next;
     }
 }
}

//Main Method
public class InventoryManagementSystem  {
 public static void main(String[] args) {
     Inventory inv = new Inventory();

     inv.addAtBeginning("Pen", 101, 50, 10.5);
     inv.addAtEnd("Notebook", 102, 20, 50);
     inv.addAtPosition("Pencil", 103, 100, 5, 1);

     System.out.println("Initial Inventory:");
     inv.display();

     inv.updateQuantity(102, 25);

     inv.searchById(101);
     inv.searchByName("Pencil");

     inv.totalValue();

     System.out.println("\nSort by Name Ascending:");
     inv.sortByName(true);
     inv.display();

     System.out.println("\nSort by Price Descending:");
     inv.sortByPrice(false);
     inv.display();
 }
}
