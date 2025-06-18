import java.util.Scanner;

public class ArrayIndexDemo {
    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names, int index) {
        System.out.println("Accessing element at index " + index + ": " + names[index]);
    }
    
    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names, int index) {
        try {
            System.out.println("Accessing element at index " + index + ": " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = scanner.nextInt();
        
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }
        
        System.out.println("Enter an index beyond array length: ");
        int index = scanner.nextInt();
        
        System.out.println("Attempting to generate exception...");
        try {
            generateException(names, index);
        } catch (Exception e) {
            System.out.println("Exception in generate method: " + e.getMessage());
        }
        
        System.out.println("\nDemonstrating exception handling...");
        handleException(names, index);
        
        scanner.close();
    }
}