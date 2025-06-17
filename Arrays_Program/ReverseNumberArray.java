import java.util.*;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num = Math.abs(num);

        int[] digits = new int[10];
        int count = 0;

        while (num > 0) {
            digits[count++] = num % 10;
            num /= 10;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
    }
}

