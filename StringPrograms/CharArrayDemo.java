import java.util.*;


public class CharArrayDemo {
    
    
    public static char[] stringToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }
    
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String input = scanner.next();
        
        char[] customArray = stringToCharArray(input);
        char[] builtInArray = input.toCharArray();
        
        System.out.println("Custom char array: " + Arrays.toString(customArray));
        System.out.println("Built-in char array: " + Arrays.toString(builtInArray));
        System.out.println("Arrays are equal: " + compareCharArrays(customArray, builtInArray));
        
        scanner.close();
    }
}