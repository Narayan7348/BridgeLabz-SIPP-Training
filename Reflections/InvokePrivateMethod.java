import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        // Get method reference
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // allow access to private method

        // Invoke method
        int result = (int) method.invoke(calc, 5, 7);
        System.out.println("Multiplication Result = " + result);
    }
}
