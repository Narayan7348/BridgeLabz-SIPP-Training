import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;
    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class Top5Movies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) movies.add(new Movie(sc.next(), sc.nextDouble(), sc.nextInt()));
        movies.stream()
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed()
              .thenComparing((Movie m) -> m.year, Comparator.reverseOrder()))
              .limit(5)
              .forEach(m -> System.out.println(m.name + " " + m.rating + " " + m.year));
    }
}
