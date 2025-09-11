import java.lang.annotation.*;
import java.lang.reflect.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed ✅");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed ✅");
    }
}

public class RoleAllowedExample {
    public static void main(String[] args) throws Exception {
        String currentRole = "USER"; // simulate user input
        SecureService service = new SecureService();

        for (Method m : SecureService.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = m.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentRole)) {
                    m.invoke(service);
                } else {
                    System.out.println("Access Denied to " + m.getName());
                }
            }
        }
    }
}
