import java.util.Scanner;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        int max = 18;
        int min = 10;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }
    }
}

