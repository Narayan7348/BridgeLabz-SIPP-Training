import java.lang.annotation.*;
import java.lang.reflect.*;

// Define custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Narayan")
    public void completeTask() {
        System.out.println("Completing important task...");
    }
}

public class CustomAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }

        new TaskManager().completeTask();
    }
}
