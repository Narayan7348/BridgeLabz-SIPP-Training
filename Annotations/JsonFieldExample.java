import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonFieldExample {
    public static String toJson(Object obj) throws Exception {
        Map<String, String> jsonMap = new HashMap<>();

        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                JsonField jf = f.getAnnotation(JsonField.class);
                jsonMap.put(jf.name(), f.get(obj).toString());
            }
        }

        return jsonMap.toString();
    }

    public static void main(String[] args) throws Exception {
        Person p = new Person("Narayan", 22);
        System.out.println("JSON Output: " + toJson(p));
    }
}
