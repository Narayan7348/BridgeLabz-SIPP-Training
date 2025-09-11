import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodCall {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MathOperations obj = new MathOperations();

        System.out.print("Enter method name (add/subtract/multiply): ");
        String methodName = sc.nextLine();

        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        Object result = method.invoke(obj, a, b);
        System.out.println("Result: " + result);
    }
}

