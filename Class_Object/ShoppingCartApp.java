

import java.util.ArrayList;
import java.util.Iterator;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    private ArrayList<CartItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

   
    public void addItem(String itemName, double price, int quantity) {
        cart.add(new CartItem(itemName, price, quantity));
        System.out.println(quantity + " x " + itemName + " added to cart.");
    }

   
    public void removeItem(String itemName) {
        Iterator<CartItem> iterator = cart.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.itemName.equalsIgnoreCase(itemName)) {
                iterator.remove();
                System.out.println(itemName + " removed from cart.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(itemName + " not found in the cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: ₹" + total);
    }

   
    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (CartItem item : cart) {
                System.out.println(item.quantity + " x " + item.itemName + " @ ₹" + item.price + " = ₹" + item.getTotalPrice());
            }
        }
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart();

        myCart.addItem("Apple", 20.0, 3);
        myCart.addItem("Milk", 45.0, 2);
        myCart.displayCart();
        myCart.displayTotalCost();

        myCart.removeItem("Milk");
        myCart.displayCart();
        myCart.displayTotalCost();
    }
}

