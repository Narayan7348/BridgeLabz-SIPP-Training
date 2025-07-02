package single_inheritance_package;

//Book superclass
class Book {
 String title;
 int publicationYear;

 // Constructor
 Book(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 // Method to display book information
 public void displayInfo() {
     System.out.println("Title: " + title);
     System.out.println("Publication Year: " + publicationYear);
 }
}

//Author subclass
class Author extends Book {
 String name;  
 String bio;    

 // Constructor 
 Author(String title, int publicationYear, String name, String bio) {
     super(title, publicationYear);  
     this.name = name;
     this.bio = bio;
 }

 // Overriding display information to include author details
 @Override
 public void displayInfo() {
     super.displayInfo(); 
     System.out.println("Author: " + name);
     System.out.println("Bio: " + bio);
 }
}

//Main class to test
public class LibraryManagement {
 public static void main(String[] args) {
     Author bookWithAuthor = new Author(
         "The Silent Voice", 
         2020, 
         "Rina Kapoor", 
         "An award-winning novelist known for contemporary fiction."
     );

     System.out.println("Book and Author Information:");
     bookWithAuthor.displayInfo();
 }
}
