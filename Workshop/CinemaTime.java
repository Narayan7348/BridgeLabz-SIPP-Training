import java.util.*;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class CinemaTime {
    private List<String> movieTitles = new ArrayList<>();
    private List<String> movieTimes = new ArrayList<>();

   
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTimeFormat(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
    }

    
    public void searchMovie(String keyword) {
        System.out.println("Search Results:");
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(String.format("Movie: %s | Showtime: %s", movieTitles.get(i), movieTimes.get(i)));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movies found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search index error: " + e.getMessage());
        }
    }

   
    public void displayAllMovies() {
        System.out.println("All Movies:");
        try {
            String[] titlesArray = movieTitles.toArray(new String[0]);
            String[] timesArray = movieTimes.toArray(new String[0]);
            for (int i = 0; i < titlesArray.length; i++) {
                System.out.println("Movie: " + titlesArray[i] + " | Showtime: " + timesArray[i]);
            }
        } catch (Exception e) {
            System.out.println("Error displaying movies: " + e.getMessage());
        }
    }

   
    private boolean isValidTimeFormat(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) return false;
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59);
    }

    
    public static void main(String[] args) {
        CinemaTime manager = new CinemaTime();
        Scanner sc = new Scanner(System.in);

        try {
            manager.addMovie("Inception", "14:30");
            manager.addMovie("Interstellar", "17:45");
            manager.addMovie("Dune", "21:15");
            
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        manager.displayAllMovies();

        System.out.print("\nEnter search keyword: ");
        String keyword = sc.nextLine();
        manager.searchMovie(keyword);
    }
}
