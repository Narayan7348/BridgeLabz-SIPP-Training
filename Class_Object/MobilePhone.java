


public class MobilePhone {
   
    String brand;
    String model;
    double price;

  
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
    }

    
    public static void main(String[] args) {
        
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy A54", 28999.00);
        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 15", 79999.00);

       
        phone1.displayDetails();
        System.out.println();
        phone2.displayDetails();
    }
}

