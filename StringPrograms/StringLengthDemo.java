import java.util.*;

public class StringLengthDemo {
    
    
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.next();
        
        int customLength = findLength(input);
        int builtInLength = input.length();
        
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);
        System.out.println("Both results are equal: " + (customLength == builtInLength));
        
        scanner.close();
    }
}