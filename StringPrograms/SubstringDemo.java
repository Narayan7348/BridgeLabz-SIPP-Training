import java.util.*;

public class SubstringDemo {
    
    
    public static String createSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    
    
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
        
        System.out.println("Enter a string: ");
        String input = scanner.next();
        
        System.out.println("Enter start index: ");
        int start = scanner.nextInt();
        
        System.out.println("Enter end index: ");
        int end = scanner.nextInt();
        
        String customSubstring = createSubstring(input, start, end);
        String builtInSubstring = input.substring(start, end);
        
        System.out.println("Custom substring: " + customSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Substrings are equal: " + compareStrings(customSubstring, builtInSubstring));
        
        scanner.close();
    }
}