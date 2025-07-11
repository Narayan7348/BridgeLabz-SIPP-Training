import java.util.*;

public class ChallengeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n) {
                mark[arr[i] - 1] = 1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) {
                missing = i + 1;
                break;
            }
        }
        System.out.println(missing);

        Arrays.sort(arr);
        int target = Integer.parseInt(scanner.nextLine());
        int left = 0, right = n - 1, index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(index);
    }
}

