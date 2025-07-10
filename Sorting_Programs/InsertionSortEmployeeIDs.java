import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ids[i] + " ");
        }
    }
}

