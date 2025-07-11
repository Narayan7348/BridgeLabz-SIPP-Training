import java.util.*;

public class SortingComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] original = new int[N];
        for (int i = 0; i < N; i++) original[i] = sc.nextInt();

        int[] arr1 = Arrays.copyOf(original, N);
        long start = System.nanoTime();
        bubbleSort(arr1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort: " + (end - start) + " ns");

        int[] arr2 = Arrays.copyOf(original, N);
        start = System.nanoTime();
        Arrays.sort(arr2);
        end = System.nanoTime();
        System.out.println("Quick Sort (Arrays.sort): " + (end - start) + " ns");

        List<Integer> list = new ArrayList<>();
        for (int i : original) list.add(i);
        start = System.nanoTime();
        list = mergeSort(list);
        end = System.nanoTime();
        System.out.println("Merge Sort: " + (end - start) + " ns");
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Integer> left = mergeSort(list.subList(0, mid));
        List<Integer> right = mergeSort(list.subList(mid, list.size()));
        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) merged.add(left.get(i++));
            else merged.add(right.get(j++));
        }
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));
        return merged;
    }
}

