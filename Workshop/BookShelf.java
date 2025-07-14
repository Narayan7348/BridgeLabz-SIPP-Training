import java.util.*;

public class BookShelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, LinkedList<String>> library = new HashMap<>();
        HashSet<String> bookSet = new HashSet<>();

        while (true) {
            String command = sc.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) break;

            String[] parts = command.split(" ", 3);
            if (parts.length < 3) continue;

            String action = parts[0];
            String genre = parts[1];
            String book = parts[2];

            if (action.equalsIgnoreCase("add")) {
                if (!bookSet.contains(book)) {
                    library.putIfAbsent(genre, new LinkedList<>());
                    library.get(genre).add(book);
                    bookSet.add(book);
                }
            } else if (action.equalsIgnoreCase("remove")) {
                if (library.containsKey(genre)) {
                    library.get(genre).remove(book);
                    bookSet.remove(book);
                }
            }
        }

        for (String genre : library.keySet()) {
            System.out.println(genre + ": " + library.get(genre));
        }
    }
}
