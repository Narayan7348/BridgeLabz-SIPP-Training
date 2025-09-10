import java.util.*;
import java.util.stream.*;

public class LibraryBookStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Book> books = new ArrayList<>();
        for(int i=0;i<n;i++){
            String title = sc.next();
            String genre = sc.next();
            int pages = sc.nextInt();
            books.add(new Book(title, genre, pages));
        }
        Map<String, IntSummaryStatistics> stats = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)));
        System.out.println(stats);
    }
}

class Book {
    private String title;
    private String genre;
    private int pages;
    public Book(String title,String genre,int pages){this.title=title;this.genre=genre;this.pages=pages;}
    public String getGenre(){return genre;}
    public int getPages(){return pages;}
}

