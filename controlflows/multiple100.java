

import java.util.;

public class multiple100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.print("Multiples of " + number + " below 100 are: ");
            int counter = 1;
            while (number * counter < 100) {
                System.out.print((number * counter) + " ");
                counter++;
            }
            System.out.println();
        }
        input.close();
    }
}