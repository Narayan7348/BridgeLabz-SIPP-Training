import java.util.*;

public class StringUpperCase1 {
    
    
    public static String convertToUpperCase(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
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
        System.out.println("Enter a text: ");
        String input = scanner.nextLine();
        
        String customUpperCase = convertToUpperCase(input);
        String builtInUpperCase = input.toUpperCase();
        boolean areEqual = compareStrings(customUpperCase, builtInUpperCase);
        
        System.out.println("Custom uppercase: " + customUpperCase);
        System.out.println("Built-in uppercase: " + builtInUpperCase);
        System.out.println("Both results are equal: " + areEqual);
        
        scanner.close();
    }
}