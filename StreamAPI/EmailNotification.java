import java.util.*;

public class EmailNotification {
    static void sendEmailNotification(String email) {
        System.out.println("Email sent to " + email);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) emails.add(sc.next());
        emails.forEach(email -> sendEmailNotification(email));
    }
}
