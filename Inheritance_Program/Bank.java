package hierarchial_inheritance_package;

//BankAccount superclass
class BankAccount {
 String accountNumber;  
 double balance;        

 // Constructor
 BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 // Method to display account details
 public void displayAccountInfo() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: Rs" + balance);
 }
}

//SavingsAccount subclass
class SavingsAccount extends BankAccount {
 double interestRate; 

 // Constructor
 SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance); 
     this.interestRate = interestRate;
 }

 // Method to display information
 public void displayAccountType() {
     System.out.println("Account Type: Savings Account");
     displayAccountInfo();
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

//CheckingAccount subclass
class CheckingAccount extends BankAccount {
 double withdrawalLimit; 

 // Constructor
 CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 // Method to display information
 public void displayAccountType() {
     System.out.println("Account Type: Checking Account");
     displayAccountInfo();
     System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
 }
}

//FixedDepositAccount
class FixedDepositAccount extends BankAccount {
 int term; 

 // Constructor
 FixedDepositAccount(String accountNumber, double balance, int term) {
     super(accountNumber, balance);
     this.term = term;
 }

 // Method to display type-specific info
 public void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
     displayAccountInfo();
     System.out.println("Term: " + term + " months");
 }
}

//Main Method
public class Bank {
 public static void main(String[] args) {
     SavingsAccount savings = new SavingsAccount("123", 10000, 4.5);
     CheckingAccount checking = new CheckingAccount("456", 5000, 2000);
     FixedDepositAccount fixed = new FixedDepositAccount("789", 25000, 12);

     System.out.println("SAVINGS ACCOUNT");
     savings.displayAccountType();

     System.out.println("\nCHECKING ACCOUNT");
     checking.displayAccountType();

     System.out.println("\nFIXED DEPOSIT ACCOUNT");
     fixed.displayAccountType();
 }
}

