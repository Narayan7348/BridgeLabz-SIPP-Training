

public class MovieTicket {
    private String movieName;
    private int seatNumber;
    private double price;
    private boolean isBooked;

   
    public MovieTicket() {
        this.isBooked = false;
    }

   
    public void bookTicket(String movieName, int seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("Ticket already booked!");
        }
    }

    
    public void displayTicket() {
        if (isBooked) {
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Ticket Price: ₹" + price);
        } else {
            System.out.println("No ticket has been booked yet.");
        }
    }

    
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.displayTicket();  

        ticket.bookTicket("Inception", 12, 250.0);  
        ticket.displayTicket(); 
        ticket.bookTicket("Avatar", 15, 300.0); 
    }
}

