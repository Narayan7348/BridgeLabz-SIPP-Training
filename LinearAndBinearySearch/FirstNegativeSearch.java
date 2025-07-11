import java.util.Scanner;

public class FirstNegativeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                index = i;
                break;
            }
        }
        System.out.println(index);
    }
}
