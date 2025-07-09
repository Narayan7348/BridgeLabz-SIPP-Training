import java.util.*;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks q = new QueueUsingStacks();
        while (true) {
            System.out.println("1. Enqueue 2. Dequeue 3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                int x = sc.nextInt();
                q.enqueue(x);
            } else if (choice == 2) {
                int val = q.dequeue();
                if (val != -1) {
                    System.out.println("Dequeued: " + val);
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}
