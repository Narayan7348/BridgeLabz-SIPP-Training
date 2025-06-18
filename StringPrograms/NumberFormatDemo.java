import java.util.*;

public class NumberFormatDemo {
    
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Converted number: " + number);
    }
    
    
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-numeric text: ");
        String input = scanner.nextLine();
        
        System.out.println("Attempting to generate exception...");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception in generate method: " + e.getMessage());
        }
        
        System.out.println("\nDemonstrating exception handling...");
        handleException(input);
        
        scanner.close();
    }
}