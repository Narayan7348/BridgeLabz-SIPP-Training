import java.util.*;

public class StringComparison {
    
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.println("Enter second string: ");
        String str2 = scanner.next();
        
        boolean customComparison = compareStrings(str1, str2);
        boolean builtInComparison = str1.equals(str2);
        
        System.out.println("Custom comparison result: " + customComparison);
        System.out.println("Built-in comparison result: " + builtInComparison);
        System.out.println("Both comparison methods give same result: " + (customComparison == builtInComparison));
        
        scanner.close();
    }
}