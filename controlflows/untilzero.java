

import java.util.Scanner;

public class untilzero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter a natural number (0 or negative to stop): ");
            int n = input.nextInt();

            if (n <= 0) {
                break;
            }
            sum += n;
        }

        System.out.println("The sum of all entered natural numbers is: " + sum);
        input.close();
    }
}