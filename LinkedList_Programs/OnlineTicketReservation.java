package linked_list_package;

//Node Class
class Ticket {
    int id;
    String customer, movie, seat, time;
    Ticket next;
    
//Constructor
    Ticket(int id, String customer, String movie, String seat, String time) {
        this.id = id;
        this.customer = customer;
        this.movie = movie;
        this.seat = seat;
        this.time = time;
    }
}

//Circular Linked List
class TicketSystem {
    Ticket head = null;

    // Add ticket at end
    public void add(int id, String c, String m, String s, String t) {
        Ticket newT = new Ticket(id, c, m, s, t);
        if (head == null) {
            head = newT;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newT;
            newT.next = head;
        }
    }

    // Remove ticket by ID
    public void remove(int id) {
        if (head == null) return;
        if (head.id == id && head.next == head) {
            head = null;
            return;
        }
        Ticket curr = head, prev = null;
        do {
            if (curr.id == id) {
                if (curr == head) {
                    Ticket last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display tickets
    public void display() {
        if (head == null) {
            System.out.println("No bookings.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.id + ", " + temp.customer + ", " + temp.movie +
                    ", Seat: " + temp.seat + ", Time: " + temp.time);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer or movie
    public void search(String cName, String mName) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if ((cName != null && temp.customer.equalsIgnoreCase(cName)) ||
                (mName != null && temp.movie.equalsIgnoreCase(mName))) {
                System.out.println("Found: " + temp.customer + " - " + temp.movie);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("Not found.");
    }

    // Count tickets
    public void count() {
        if (head == null) {
            System.out.println("Total: 0");
            return;
        }
        int cnt = 0;
        Ticket temp = head;
        do {
            cnt++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total: " + cnt);
    }
}

//Main Method
public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketSystem t = new TicketSystem();

        t.add(1, "Rohit", "Raid 2", "G1", "10PM");
        t.add(2, "Rahul", "Singh Is King", "S2", "1PM");
        t.add(3, "Ravi", "3 Idiots", "G3", "7AM");

        t.display();
        t.search("Ravi", null);
        t.search(null, "Raid 2");
        t.count();

        t.remove(2);
        System.out.println("After removal:");
        t.display();
        t.count();
    }
}

