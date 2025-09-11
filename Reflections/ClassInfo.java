import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter class name (e.g., java.util.ArrayList): ");
        String className = sc.nextLine();

        // Load class dynamically
        Class<?> clazz = Class.forName(className);

        // Print class methods
        System.out.println("\n--- Methods ---");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }

        // Print class fields
        System.out.println("\n--- Fields ---");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }

        // Print class constructors
        System.out.println("\n--- Constructors ---");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}

