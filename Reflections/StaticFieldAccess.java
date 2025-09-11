import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class StaticFieldAccess {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Configuration.class;

        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Old API_KEY: " + field.get(null)); // static → pass null

        field.set(null, "NEW_SECRET_KEY");

        System.out.println("Updated API_KEY: " + field.get(null));
    }
}
