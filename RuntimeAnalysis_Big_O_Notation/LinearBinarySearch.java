import java.util.*;

public class LinearBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();

        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            if (arr[i] == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Linear Search Time: " + (end - start) + " ns");

        Arrays.sort(arr);
        start = System.nanoTime();
        int l = 0, r = N - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) break;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        end = System.nanoTime();
        System.out.println("Binary Search Time: " + (end - start) + " ns");
    }
}
