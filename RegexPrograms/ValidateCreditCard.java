import java.util.*;
public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();
        System.out.println(card.matches("^4\\d{15}$") || card.matches("^5\\d{15}$") ? "Valid" : "Invalid");
    }
}
