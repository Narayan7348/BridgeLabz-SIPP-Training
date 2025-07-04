package linked_list_package;

//Node Class
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;
    
//Constructor
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

//Doubly Linked List
class MovieList {
    private Movie head;
    private Movie tail;

    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at specific position
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int i = 1;

        while (temp != null && i < position - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found with title: " + title);
    }

    // Search by Director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search by Rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Display forward
    public void displayForward() {
        Movie temp = head;
        System.out.println("\nForward");
        if (temp == null) System.out.println("No movies in the list");
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Movie temp = tail;
        System.out.println("\nReverse");
        if (temp == null) System.out.println("No movies in the list");
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    // Update rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + title);
    }

    private void printMovie(Movie movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director +
                           ", Year: " + movie.year + ", Rating: " + movie.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtEnd("Raid 2", "Raj Kumar Gupta", 2025, 6.9);
        list.addAtBeginning("Kesari Chapter 2: The Untold Story of Jallianwala Bagh", "Karan Singh Tyagi", 2025, 8.0);
        list.addAtEnd("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        list.addAtPosition(2, "12th Fail", "Vidhu Vinod Chopra", 2013, 8.7);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Rajkumar Hirani");
        list.searchByRating(6.9);

        list.updateRating("3 Idiots", 8.7);
        list.removeByTitle("12th Fail");

        list.displayForward();
    }
}

