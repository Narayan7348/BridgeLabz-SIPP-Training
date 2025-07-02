package multilevel_inheritance_package;

//Order superclass
class Order {
 String orderId;
 String orderDate;

 // Constructor
 Order(String orderId, String orderDate) {
     this.orderId = orderId;
     this.orderDate = orderDate;
 }

 // Method to return order status
 String getOrderStatus() {
     return "Order placed";
 }

 // Display common order information
 public void displayOrderInfo() {
     System.out.println("Order ID: " + orderId);
     System.out.println("Order Date: " + orderDate);
 }
}

//ShippedOrder subclass
class ShippedOrder extends Order {
 String trackingNumber;

 // Constructor
 ShippedOrder(String orderId, String orderDate, String trackingNumber) {
     super(orderId, orderDate);  // Call Order constructor
     this.trackingNumber = trackingNumber;
 }

 // Override to return updated status
 @Override
 String getOrderStatus() {
     return "Order shipped. Tracking Number: " + trackingNumber;
 }

 // Display additional shipping information
 @Override
 public void displayOrderInfo() {
     super.displayOrderInfo();
     System.out.println("Tracking Number: " + trackingNumber);
 }
}

//DeliveredOrder subclass
class DeliveredOrder extends ShippedOrder {
 String deliveryDate;

 // Constructor
 DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);  
     this.deliveryDate = deliveryDate;
 }

 // Override to show final delivery status
 @Override
 String getOrderStatus() {
     return "Order delivered on " + deliveryDate;
 }

 // Display all order information
 @Override
 public void displayOrderInfo() {
     super.displayOrderInfo(); 
     System.out.println("Delivery Date: " + deliveryDate);
 }
}

//Main Method
public class OnlineRetail {
 public static void main(String[] args) {
     DeliveredOrder order = new DeliveredOrder(
         "12345", 
         "2025-06-25", 
         "987654321", 
         "2025-06-30"
     );

     System.out.println("Order Details:");
     order.displayOrderInfo();

     System.out.println("\nOrder Status: " + order.getOrderStatus());
 }
}

