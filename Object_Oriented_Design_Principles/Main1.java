import java.util.*;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        for (Book b : books) {
            System.out.println(b.title + " by " + b.author);
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Alice");
        Book b2 = new Book("OOP Concepts", "Bob");

        Library lib1 = new Library();
        Library lib2 = new Library();

        lib1.addBook(b1);
        lib2.addBook(b2);

        System.out.println("Library 1:");
        lib1.showBooks();

        System.out.println("Library 2:");
        lib2.showBooks();
    }
}

