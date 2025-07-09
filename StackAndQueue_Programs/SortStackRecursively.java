import java.util.*;

public class SortStackRecursively {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertSorted(stack, x);
        }
    }

    public static void insertSorted(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
        } else {
            int temp = stack.pop();
            insertSorted(stack, x);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        sortStack(stack);
        System.out.println("Sorted stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
