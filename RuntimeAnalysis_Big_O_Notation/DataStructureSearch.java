import java.util.*;

public class DataStructureSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            hashSet.add(arr[i]);
            treeSet.add(arr[i]);
        }
        int target = sc.nextInt();

        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            if (arr[i] == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Array: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet: " + (end - start) + " ns");
    }
}
