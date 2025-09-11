import java.util.ArrayList;

public class SuppressWarningExample {
    @SuppressWarnings("unchecked") // Hides generic type warning
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw type without generics
        list.add("Hello");
        list.add(123); // Adding different types

        System.out.println("ArrayList content: " + list);
    }
}
