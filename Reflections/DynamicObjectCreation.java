import java.lang.reflect.*;

class Student {
    String name;
    public Student() {
        this.name = "Default Student";
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        // Get class
        Class<?> clazz = Class.forName("Student");

        // Create object without new keyword
        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Object created: " + obj.getClass().getName());
    }
}

