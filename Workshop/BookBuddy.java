

import java.util.*;

public class BookBuddy {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String title, String author) {
        books.add(title + " - " + author);
    }
    

    void sortBooks() {
        for (int i = 0; i < books.size() - 1; i++)
            for (int j = i + 1; j < books.size(); j++)
            	
                if (books.get(i).compareToIgnoreCase(books.get(j)) > 0) {
                    String temp = books.get(i);
                    books.set(i, books.get(j));
                    
                    books.set(j, temp);
                }
        
    }

    void searchByAuthor(String author) {
        boolean found = false;
        for (String book : books) {
            String[] parts = book.split(" - ");
            if (parts.length == 2 && parts[1].equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found.");
    }

    void export() {
        String[] arr = books.toArray(new String[0]);
        for (String book : arr) {
            String[] str = book.split(" - ");
            
            if (str.length == 2)
            	
                System.out.println("Title: " + str[0] + ", Author: " + str[1]);
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookBuddy obj = new BookBuddy();

        while (true) {
        	
            int choose = sc.nextInt(); sc.nextLine();
            
            if (choose == 1) {
                System.out.print("Title: ");
                
                String t = sc.nextLine();
                
                System.out.print("Author: ");
                
                String a = sc.nextLine();
                obj.addBook(t, a);
            } else if (choose == 2) obj.sortBooks();
            else if (choose == 3) {
            	
                System.out.print("Author to search: ");
                obj.searchByAuthor(sc.nextLine());
            } else if (choose == 4) obj.export();
            else if (choose == 5) break;
            
            else System.out.println("Invalid.");
        }
        
    }
}