import java.util.*;

class Invoice {
    String transactionId;
    Invoice(String transactionId) { this.transactionId = transactionId; }
    public String toString() { return "Invoice for " + transactionId; }
}

class InvoiceCreation {
    public static void main(String[] args) {
        List<String> transactions = Arrays.asList("TXN1", "TXN2", "TXN3");
        transactions.stream().map(Invoice::new).forEach(System.out::println);
    }
}
