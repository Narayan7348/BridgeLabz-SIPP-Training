import java.util.*;

public class WordLengthAnalysis {
    
   
    private static String[] splitWords(String text) {
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }
        
        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = currentWord.toString();
                currentWord = new StringBuilder();
            } else {
                currentWord.append(text.charAt(i));
            }
        }
        words[wordIndex] = currentWord.toString();
        
        return words;
    }
    
    
    private static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    
    
    private static String[][] createWordLengthPairs(String[] words) {
        String[][] pairs = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            pairs[i][0] = words[i];
            pairs[i][1] = String.valueOf(findLength(words[i]));
        }
        return pairs;
    }
    
    
    private static String[] findExtremeWords(String[][] wordLengths) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        String shortest = "";
        String longest = "";
        
        for (String[] pair : wordLengths) {
            int length = Integer.parseInt(pair[1]);
            if (length < minLength) {
                minLength = length;
                shortest = pair[0];
            }
            if (length > maxLength) {
                maxLength = length;
                longest = pair[0];
            }
        }
        
        return new String[]{shortest, longest};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to analyze: ");
        String input = scanner.nextLine();
        
        String[] words = splitWords(input);
        String[][] wordLengths = createWordLengthPairs(words);
        String[] extremeWords = findExtremeWords(wordLengths);
        
        System.out.println("\nWord Analysis:");
        System.out.println("Word     | Length");
        System.out.println("---------|--------");
        for (String[] pair : wordLengths) {
            System.out.printf("%-8s | %s%n", pair[0], pair[1]);
        }
        
        System.out.println("\nResults:");
        System.out.println("Shortest word: " + extremeWords[0]);
        System.out.println("Longest word: " + extremeWords[1]);
        
        scanner.close();
    }
}