package oops_day_03_package;

class Book {
	
	   // Static variable
	   private static String libraryName;
	   
	   // Instance variable
	   private String title;
	   private String author;
	   
	   // Final variable
	   private final String isbn; 
	   
	   // Constructor
	   public Book(String title, String author, String isbn) {
	       this.title = title;
	       this.author = author;
	       this.isbn = isbn;
	   }
	   
	   // Static method to set the library name
	   public static void setLibraryName(String name) {
	       libraryName = name;
	   }
	   
	   // Static method to display the library name
	   public static void displayLibraryName() {
	       System.out.println("Library Name: " + libraryName);
	   }
	   
	   // Method to display book details
	   public void displayBookDetails() {
	       if (this instanceof Book) {
	           System.out.println("Title: " + title);
	           System.out.println("Author: " + author);
	           System.out.println("ISBN: " + isbn);
	       } else {
	           System.out.println("The object is not an instance of the Book class");
	       }
	   }
	   
	   // Getters for instance variables
	   public String getTitle() {
	       return title;
	   }
	   public String getAuthor() {
	       return author;
	   }
	   public String getIsbn() {
	       return isbn;
	   }
	}

	public class Library {
	   public static void main(String[] args) {
	       Book.setLibraryName("College Library");
	       
	       Book.displayLibraryName();
	       
	       Book book1 = new Book("Java Architecture", "William Jacks", "1234567890");
	       
	       book1.displayBookDetails();
	   }
	}

