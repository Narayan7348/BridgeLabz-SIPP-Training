import java.util.*;

public class WelcomeAttendees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> attendees = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) attendees.add(sc.next());
        attendees.forEach(a -> System.out.println("Welcome " + a));
    }
}
