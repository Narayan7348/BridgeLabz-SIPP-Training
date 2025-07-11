import java.util.*;

public class SearchProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Linear Search Problem 1
        int n1 = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }
        int result1 = -1;
        for (int i = 0; i < n1; i++) {
            if (arr1[i] < 0) {
                result1 = i;
                break;
            }
        }
        System.out.println(result1);

        // Linear Search Problem 2
        int n2 = Integer.parseInt(scanner.nextLine());
        String[] sentences = new String[n2];
        for (int i = 0; i < n2; i++) {
            sentences[i] = scanner.nextLine();
        }
        String word = scanner.nextLine();
        String result2 = "Not Found";
        for (int i = 0; i < n2; i++) {
            if (sentences[i].contains(word)) {
                result2 = sentences[i];
                break;
            }
        }
        System.out.println(result2);

        // Binary Search Problem 1
        int n3 = Integer.parseInt(scanner.nextLine());
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = Integer.parseInt(scanner.nextLine());
        }
        int left = 0;
        int right = n3 - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr3[mid] > arr3[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);

        // Binary Search Problem 2
        int n4 = Integer.parseInt(scanner.nextLine());
        int[] arr4 = new int[n4];
        for (int i = 0; i < n4; i++) {
            arr4[i] = Integer.parseInt(scanner.nextLine());
        }
        int l = 0, r = n4 - 1, peak = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            boolean leftCheck = mid == 0 || arr4[mid] > arr4[mid - 1];
            boolean rightCheck = mid == n4 - 1 || arr4[mid] > arr4[mid + 1];
            if (leftCheck && rightCheck) {
                peak = arr4[mid];
                break;
            } else if (mid > 0 && arr4[mid] < arr4[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(peak);

        // Binary Search Problem 3
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        int target = Integer.parseInt(scanner.nextLine());
        int start = 0, end = rows * cols - 1;
        boolean found = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                found = true;
                break;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(found);

        // Binary Search Problem 4
        int n5 = Integer.parseInt(scanner.nextLine());
        int[] arr5 = new int[n5];
        for (int i = 0; i < n5; i++) {
            arr5[i] = Integer.parseInt(scanner.nextLine());
        }
        int key = Integer.parseInt(scanner.nextLine());
        int first = -1, last = -1;
        int lo = 0, hi = n5 - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr5[mid] < key) {
                lo = mid + 1;
            } else if (arr5[mid] > key) {
                hi = mid - 1;
            } else {
                first = mid;
                hi = mid - 1;
            }
        }
        lo = 0;
        hi = n5 - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr5[mid] < key) {
                lo = mid + 1;
            } else if (arr5[mid] > key) {
                hi = mid - 1;
            } else {
                last = mid;
                lo = mid + 1;
            }
        }
        System.out.println(first + " " + last);

        // Challenge Problem
        int n6 = Integer.parseInt(scanner.nextLine());
        int[] arr6 = new int[n6];
        for (int i = 0; i < n6; i++) {
            arr6[i] = Integer.parseInt(scanner.nextLine());
        }
        int[] mark = new int[n6];
        for (int i = 0; i < n6; i++) {
            if (arr6[i] > 0 && arr6[i] <= n6) {
                mark[arr6[i] - 1] = 1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n6; i++) {
            if (mark[i] == 0) {
                missing = i + 1;
                break;
            }
        }
        System.out.println(missing);

        Arrays.sort(arr6);
        int target2 = Integer.parseInt(scanner.nextLine());
        int index = -1;
        int s = 0, e = n6 - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr6[m] == target2) {
                index = m;
                break;
            } else if (arr6[m] < target2) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        System.out.println(index);
    }
}
