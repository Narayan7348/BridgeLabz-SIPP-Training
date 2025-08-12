import java.util.*;
public class ValidateHexColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.nextLine();
        System.out.println(hex.matches("^#[0-9A-Fa-f]{6}$") ? "Valid" : "Invalid");
    }
}
