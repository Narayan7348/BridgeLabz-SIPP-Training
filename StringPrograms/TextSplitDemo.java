import java.util.*;


public class TextSplitDemo {
    
    
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    
  
    public static String[] customSplit(String text) {
        
        int wordCount = 1;
        int[] spaceIndexes = new int[findLength(text)];
        int spaceCount = 0;
        
        for (int i = 0; i < findLength(text); i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount++] = i;
                wordCount++;
            }
        }
        
      
        String[] words = new String[wordCount];
        int startIndex = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            words[i] = extractWord(text, startIndex, spaceIndexes[i]);
            startIndex = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = extractWord(text, startIndex, findLength(text));
        
        return words;
    }
    
    private static String extractWord(String text, int start, int end) {
        StringBuilder word = new StringBuilder();
        for (int i = start; i < end; i++) {
            word.append(text.charAt(i));
        }
        return word.toString();
    }
    
    
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text with multiple words: ");
        String input = scanner.nextLine();
        
        String[] customSplitResult = customSplit(input);
        String[] builtInSplitResult = input.split(" ");
        
        System.out.println("Custom split result: " + Arrays.toString(customSplitResult));
        System.out.println("Built-in split result: " + Arrays.toString(builtInSplitResult));
        System.out.println("Results are equal: " + compareArrays(customSplitResult, builtInSplitResult));
        
        scanner.close();
    }
}