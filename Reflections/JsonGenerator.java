import java.lang.reflect.*;

class Product {
    String name = "Laptop";
    double price = 55000.50;
    int quantity = 2;
}

public class JsonGenerator {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String key = fields[i].getName();
            Object value = fields[i].get(obj);

            json.append("\"").append(key).append("\": ");

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) json.append(", ");
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Product p = new Product();
        System.out.println("JSON: " + toJson(p));
    }
}
