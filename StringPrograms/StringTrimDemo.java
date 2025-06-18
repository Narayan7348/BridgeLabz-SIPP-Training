import java.util.*;

public class StringTrimDemo {
    
    
    public static int[] findTrimPoints(String str) {
        int start = 0, end = str.length() - 1;
        
        
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        
        
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end + 1};
    }
    
    
    public static String customSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text with leading/trailing spaces: ");
        String input = scanner.nextLine();
        
        int[] trimPoints = findTrimPoints(input);
        String customTrimmed = customSubstring(input, trimPoints[0], trimPoints[1]);
        String builtInTrimmed = input.trim();
        
        System.out.println("Custom trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in trimmed: '" + builtInTrimmed + "'");
        System.out.println("Results are equal: " + compareStrings(customTrimmed, builtInTrimmed));
        
        scanner.close();
    }
}