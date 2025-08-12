import java.util.*;
public class ValidateLicensePlate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plate = sc.nextLine();
        System.out.println(plate.matches("^[A-Z]{2}\\d{4}$") ? "Valid" : "Invalid");
    }
}
