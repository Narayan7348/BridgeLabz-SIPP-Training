import java.lang.annotation.*;
import java.lang.reflect.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Calculator {
    @LogExecutionTime
    public void slowOperation() throws InterruptedException {
        Thread.sleep(500); // Simulating slow work
        System.out.println("Finished slow operation!");
    }

    @LogExecutionTime
    public void fastOperation() {
        System.out.println("Finished fast operation!");
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        for (Method m : Calculator.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(calc);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}
