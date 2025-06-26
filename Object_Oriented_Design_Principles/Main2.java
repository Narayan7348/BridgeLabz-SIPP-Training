class Customer {
    String name;
    double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(name + "'s Balance: $" + balance);
    }
}

class Bank {
    String bankName;

    Bank(String name) {
        this.bankName = name;
    }

    void openAccount(Customer customer) {
        System.out.println("Account opened for " + customer.name + " at " + bankName);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        Customer customer = new Customer("John", 1000);

        bank.openAccount(customer);
        customer.viewBalance();
    }
}

