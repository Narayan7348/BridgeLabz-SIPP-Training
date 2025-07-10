import java.util.Scanner;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(scores[i] + " ");
        }
    }
}

