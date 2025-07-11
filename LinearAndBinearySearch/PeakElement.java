  
import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int left = 0, right = n - 1, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean leftOk = mid == 0 || arr[mid] > arr[mid - 1];
            boolean rightOk = mid == n - 1 || arr[mid] > arr[mid + 1];
            if (leftOk && rightOk) {
                result = arr[mid];
                break;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}

