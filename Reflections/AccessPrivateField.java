import java.lang.reflect.*;

class Person {
    private int age = 25; // private field
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        // Get class object
        Class<?> clazz = p.getClass();

        // Access private field
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);

        // Get old value
        System.out.println("Old Age: " + ageField.get(p));

        // Set new value
        ageField.set(p, 30);

        // Get updated value
        System.out.println("Updated Age: " + ageField.get(p));
    }
}

