import java.lang.annotation.*;
import java.lang.reflect.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod
    public void criticalOperation() {
        System.out.println("Running critical operation...");
    }

    @ImportantMethod(level = "LOW")
    public void optionalOperation() {
        System.out.println("Running optional operation...");
    }

    public void normalOperation() {
        System.out.println("Running normal operation...");
    }
}

public class ImportantMethodExample {
    public static void main(String[] args) throws Exception {
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = m.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + m.getName() + " | Level: " + imp.level());
            }
        }
    }
}

