

import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

   
    BankAccount(String name, String number, double bal) {
        accountHolder = name;
        accountNumber = number;
        balance = bal;
    }

    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Not enough balance!");
        }
    }

   
    void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        BankAccount myAccount = new BankAccount("Bhaskar", "9876543210", 5000);

        int choice;
        do {
           
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            double amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    amount = sc.nextDouble();
                    myAccount.deposit(amount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    amount = sc.nextDouble();
                    myAccount.withdraw(amount);
                    break;

                case 3:
                    myAccount.showBalance();
                    break;

                case 4:
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

