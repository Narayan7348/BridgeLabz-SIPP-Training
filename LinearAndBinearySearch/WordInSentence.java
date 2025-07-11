import java.util.Scanner;

public class WordInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }
        String word = scanner.nextLine();
        String result = "Not Found";
        for (int i = 0; i < n; i++) {
            if (sentences[i].contains(word)) {
                result = sentences[i];
                break;
            }
        }
        System.out.println(result);
    }
}

