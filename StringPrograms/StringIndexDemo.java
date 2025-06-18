import java.util.*;

public class StringIndexDemo {
    
    
    public static void generateException(String text, int index) {
        char ch = text.charAt(index);
        System.out.println("Character at index " + index + ": " + ch);
    }
    
    
    public static void handleException(String text, int index) {
        try {
            char ch = text.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.println("Enter an index beyond string length: ");
        int index = scanner.nextInt();
        
        System.out.println("Attempting to generate exception...");
        try {
            generateException(input, index);
        } catch (Exception e) {
            System.out.println("Exception in generate method: " + e.getMessage());
        }
        
        System.out.println("\nDemonstrating exception handling...");
        handleException(input, index);
        
        
    }
}