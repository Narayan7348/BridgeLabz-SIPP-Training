package linked_list_package;

//Node class
class Book {
 String title, author, genre;
 int id;
 boolean available;
 Book prev, next;

 // Constructor
 Book(String title, String author, String genre, int id, boolean available) {
     this.title = title;
     this.author = author;
     this.genre = genre;
     this.id = id;
     this.available = available;
 }
}

//Doubly Linked List
class Library {
 Book head = null, tail = null;

 // Add at beginning
 void addAtBeginning(String title, String author, String genre, int id, boolean available) {
     Book newBook = new Book(title, author, genre, id, available);
     if (head == null) head = tail = newBook;
     else {
         newBook.next = head;
         head.prev = newBook;
         head = newBook;
     }
 }

 // Add at end
 void addAtEnd(String title, String author, String genre, int id, boolean available) {
     Book newBook = new Book(title, author, genre, id, available);
     if (head == null) head = tail = newBook;
     else {
         tail.next = newBook;
         newBook.prev = tail;
         tail = newBook;
     }
 }

 // Add at specific position
 void addAtPosition(String title, String author, String genre, int id, boolean available, int pos) {
     if (pos <= 1 || head == null) {
         addAtBeginning(title, author, genre, id, available);
         return;
     }
     Book newBook = new Book(title, author, genre, id, available);
     Book temp = head;
     for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
     if (temp == null || temp.next == null) addAtEnd(title, author, genre, id, available);
     else {
         newBook.next = temp.next;
         newBook.prev = temp;
         temp.next.prev = newBook;
         temp.next = newBook;
     }
 }

 // Remove book by ID
 public void removeById(int id) {
     Book temp = head;
     while (temp != null && temp.id != id) temp = temp.next;
     if (temp == null) return;
     if (temp == head) head = head.next;
     if (temp == tail) tail = tail.prev;
     if (temp.prev != null) temp.prev.next = temp.next;
     if (temp.next != null) temp.next.prev = temp.prev;
 }

 // Search by title or author
 public void search(String keyword) {
     Book temp = head;
     while (temp != null) {
         if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword))
             printBook(temp);
         temp = temp.next;
     }
 }

 // Update availability
 public void updateAvailability(int id, boolean status) {
     Book temp = head;
     while (temp != null) {
         if (temp.id == id) {
             temp.available = status;
             return;
         }
         temp = temp.next;
     }
 }

 // Display all books forward
 public void displayForward() {
     Book temp = head;
     while (temp != null) {
         printBook(temp);
         temp = temp.next;
     }
 }

 // Display all books reverse
 public void displayReverse() {
     Book temp = tail;
     while (temp != null) {
         printBook(temp);
         temp = temp.prev;
     }
 }

 // Count total books
 int countBooks() {
     int count = 0;
     Book temp = head;
     while (temp != null) {
         count++;
         temp = temp.next;
     }
     return count;
 }

 // Print book details
 void printBook(Book b) {
     System.out.println("ID: " + b.id + " Title: " + b.title + " Author: " + b.author + 
                        " Genre: " + b.genre + " Available: " + (b.available ? "Yes" : "No"));
 }
}

//Main method
public class LibraryManagementSystem {
 public static void main(String[] args) {
     Library lib = new Library();

     lib.addAtBeginning("The God of Small Things", "Arundhati Roy", " Literary Fiction", 1, true);
     lib.addAtEnd("Sea of Poppies", "Amitav Ghos", "Historical Fiction)", 2, false);
     lib.addAtPosition("2 States: The Story of My Marriage", "Chetan Bhagat", "Contemporary Fiction", 3, true, 2);

     System.out.println("Books in forward order:");
     lib.displayForward();

     System.out.println("\nBooks in reverse order:");
     lib.displayReverse();

     System.out.println("\nSearching 'Arundhati Roy':");
     lib.search("Arundhati Roy");

     lib.updateAvailability(2, true);
     lib.removeById(1);

     System.out.println("\nAfter update and removal:");
     lib.displayForward();

     System.out.println("\nTotal books in library: " + lib.countBooks());
 }
}
