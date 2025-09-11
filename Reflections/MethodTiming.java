import java.lang.reflect.*;

// Sample class with methods
class Task {
    public void fastTask() throws InterruptedException {
        Thread.sleep(100); // 100 ms
        System.out.println("Fast task done!");
    }

    public void slowTask() throws InterruptedException {
        Thread.sleep(500); // 500 ms
        System.out.println("Slow task done!");
    }
}

public class MethodTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();

        // Dynamically get all methods
        for (Method method : Task.class.getDeclaredMethods()) {
            long start = System.currentTimeMillis();
            method.invoke(task); // run method
            long end = System.currentTimeMillis();

            System.out.println("Execution time of " + method.getName() + " = " + (end - start) + " ms");
        }
    }
}
