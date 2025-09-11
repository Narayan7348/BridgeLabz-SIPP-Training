import java.lang.annotation.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(8)
    private String username;

    public User(String username) {
        if (username.length() > 8) {
            throw new IllegalArgumentException("❌ Username too long! Max length = 8");
        }
        this.username = username;
    }

    public void display() {
        System.out.println("User created: " + username);
    }
}

public class MaxLengthExample {
    public static void main(String[] args) {
        try {
            User u1 = new User("Narayan");
            u1.display();

            User u2 = new User("VeryLongUsername"); // throws exception
            u2.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
