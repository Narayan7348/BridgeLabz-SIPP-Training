import java.lang.annotation.*;
import java.lang.reflect.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login feature", assignedTo = "Narayan", priority = "HIGH")
    public void login() {}

    @Todo(task = "Optimize database queries", assignedTo = "Raj", priority = "LOW")
    public void optimizeDB() {}

    public void completedFeature() {}
}

public class TodoAnnotationExample {
    public static void main(String[] args) throws Exception {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + t.task() +
                        " | Assigned To: " + t.assignedTo() +
                        " | Priority: " + t.priority());
            }
        }
    }
}
