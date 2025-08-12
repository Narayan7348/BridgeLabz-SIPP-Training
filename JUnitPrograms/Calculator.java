import java.util.Scanner;

public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Add: " + calc.add(a, b));
        System.out.println("Subtract: " + calc.subtract(a, b));
        System.out.println("Multiply: " + calc.multiply(a, b));
        try {
            System.out.println("Divide: " + calc.divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
