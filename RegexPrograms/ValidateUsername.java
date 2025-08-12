import java.util.*;
public class ValidateUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println(username.matches("^[A-Za-z]\\w{4,14}$") ? "Valid" : "Invalid");
    }
}
 
    

