//ImplementCustomHashmap
import java.util.*;

class CustomHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 100;
    private Node[] table;

    public CustomHashMap() {
        table = new Node[SIZE];
    }

    private int hash(int key) {
        return Math.abs(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public Integer get(int key) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) table[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

public class ImplementCustomHashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String op = sc.next();
            if (op.equals("put")) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key, value);
            } else if (op.equals("get")) {
                int key = sc.nextInt();
                Integer val = map.get(key);
                System.out.println(val != null ? val : "null");
            } else if (op.equals("remove")) {
                int key = sc.nextInt();
                map.remove(key);
            }
        }
    }
}
