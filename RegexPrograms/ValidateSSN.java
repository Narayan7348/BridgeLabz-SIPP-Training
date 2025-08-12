import java.util.*;
public class ValidateSSN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ssn = sc.nextLine();
        System.out.println(ssn.matches("^\\d{3}-\\d{2}-\\d{4}$") ? "Valid" : "Invalid");
    }
}
