import java.util.*;

public class IllegalArgumentDemo {
    
    public static String generateException(String text, int start, int end) {
        return text.substring(start, end);
    }
    
    
    public static void handleException(String text, int start, int end) {
        try {
            String result = text.substring(start, end);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.println("Enter start index (greater than end index): ");
        int start = scanner.nextInt();
        System.out.println("Enter end index: ");
        int end = scanner.nextInt();
        
        System.out.println("Attempting to generate exception...");
        try {
            generateException(input, start, end);
        } catch (Exception e) {
            System.out.println("Exception in generate method: " + e.getMessage());
        }
        
        System.out.println("\nDemonstrating exception handling...");
        handleException(input, start, end);
        
        scanner.close();
    }
}