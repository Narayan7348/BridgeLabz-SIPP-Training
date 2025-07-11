import java.util.Scanner;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int key = Integer.parseInt(scanner.nextLine());
        int first = -1, last = -1;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                first = mid;
                high = mid - 1;
            }
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                last = mid;
                low = mid + 1;
            }
        }
        System.out.println(first + " " + last);
    }
}

