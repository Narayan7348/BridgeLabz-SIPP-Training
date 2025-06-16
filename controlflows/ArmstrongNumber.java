import java.util.*;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int sum = 0;
        int o=n;
        while (o != 0) {
            int digit = o % 10;
            sum += digit * digit * digit;
            o /= 10;
        }
        if (sum == n) {
            System.out.println(n + " is an Armstrong Number.");
        } else {
            System.out.println(n + " is not an Armstrong Number.");
        }
        sc.close();
    }
}
