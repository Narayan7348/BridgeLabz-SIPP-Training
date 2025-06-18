import java.util.Scanner;

public class CharacterTypeDemo {
    
    // Method to check character type
    public static String getCharacterType(char ch) {
        // Convert to lowercase if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        
        // Check character type
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    
    // Method to analyze string characters
    public static String[][] analyzeString(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = getCharacterType(str.charAt(i));
        }
        return result;
    }
    
    // Method to display result in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("Character | Type");
        System.out.println("----------|--------------");
        for (String[] row : data) {
            System.out.printf("%-9s | %-12s%n", row[0], row[1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to analyze: ");
        String input = scanner.nextLine();
        
        String[][] analysis = analyzeString(input);
        displayTable(analysis);
        
        scanner.close();
    }
}