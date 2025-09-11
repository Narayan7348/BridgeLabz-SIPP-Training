import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Service class
class Service {
    public void doWork() {
        System.out.println("Service is working...");
    }
}

// Client class
class Client {
    @Inject
    Service service;

    public void run() {
        service.doWork();
    }
}

// Simple DI Container
class SimpleDI {
    public static void injectDependencies(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) throws Exception {
        Client client = new Client();

        // Inject dependencies
        SimpleDI.injectDependencies(client);

        // Run method
        client.run();
    }
}
