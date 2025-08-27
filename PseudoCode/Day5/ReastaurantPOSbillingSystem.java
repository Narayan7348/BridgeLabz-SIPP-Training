/*// Step 1: Tax abstraction
interface TaxCalculator {
    double calculateTax(double price);
}

class FoodTax implements TaxCalculator {
    double calculateTax(double price) { return price * 0.05; }
}

class BeverageTax implements TaxCalculator {
    double calculateTax(double price) { return price * 0.12; }
}

class ImportedTax implements TaxCalculator {
    double calculateTax(double price) { return price * 0.05 + 50; } // customs duty
}

// Step 2: Discount abstraction
interface DiscountPolicy {
    double applyDiscount(double total);
}

class NoDiscount implements DiscountPolicy {
    double applyDiscount(double total) { return total; }
}

class FlatDiscount implements DiscountPolicy {
    double applyDiscount(double total) { return total - 100; }
}

class PercentageDiscount implements DiscountPolicy {
    double applyDiscount(double total) { return total * 0.90; } // 10% off
}

// Step 3: Item class
class MenuItem {
    String name;
    double price;
    TaxCalculator tax;

    double getFinalPrice() {
        return price + tax.calculateTax(price);
    }
}

// Step 4: Bill class
class Bill {
    List<MenuItem> items;
    DiscountPolicy discount;

    double calculateTotal() {
        double sum = 0;
        for(MenuItem item : items) sum += item.getFinalPrice();
        return discount.applyDiscount(sum);
    }
}

// Step 5: Demonstration
main() {
    MenuItem paneer = new MenuItem("Paneer Tikka", 200, new FoodTax());
    MenuItem coke = new MenuItem("Coke", 100, new BeverageTax());
    MenuItem cheese = new MenuItem("Imported Cheese", 300, new ImportedTax());

    Bill bill = new Bill([paneer, coke, cheese], new PercentageDiscount());
    print("Final Bill: " + bill.calculateTotal());

    // Tomorrow: Add Buy1Get1 discount without touching main billing code
    class Buy1Get1 implements DiscountPolicy {
        double applyDiscount(double total) { return total / 2; }
    }
    bill.discount = new Buy1Get1();
    print("Final Bill (B1G1): " + bill.calculateTotal());
}
*/
