import java.util.*;
import java.util.stream.*;
import java.time.*;

class Member {
    String name;
    LocalDate expiry;
    Member(String name, LocalDate expiry) {
        this.name = name;
        this.expiry = expiry;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++) members.add(new Member(sc.next(), LocalDate.parse(sc.next())));
        LocalDate today = LocalDate.now();
        members.stream()
               .filter(m -> !m.expiry.isBefore(today) && !m.expiry.isAfter(today.plusDays(30)))
               .forEach(m -> System.out.println(m.name + " " + m.expiry));
    }
}
