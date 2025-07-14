import java.util.*;

class Node {
    String url;
    Node prev, next;

    Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node current;

    void visit(String url) {
        Node node = new Node(url);
        if (current != null) {
            current.next = node;
            node.prev = current;
        }
        current = node;
    }

    void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Current: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Current: " + current.url);
        } else {
            System.out.println("No forward page.");
        }
    }

    void currentPage() {
        if (current != null) {
            System.out.println("Current: " + current.url);
        } else {
            System.out.println("No page visited.");
        }
    }
}

public class BrowserHistoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserHistory history = new BrowserHistory();

        while (true) {
            String command = sc.nextLine();
            if (command.equals("exit")) break;
            else if (command.startsWith("visit ")) {
                String url = command.substring(6);
                history.visit(url);
                history.currentPage();
            } else if (command.equals("back")) {
                history.back();
            } else if (command.equals("forward")) {
                history.forward();
            } else if (command.equals("current")) {
                history.currentPage();
            }
        }

        
    }
}
