import java.lang.reflect.*;
import java.util.*;

class Employee {
    String name;
    int age;
    String department;
}

public class ObjectMapperExample {
    // Generic method to map values from Map to Object fields
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(obj, entry.getValue());
            } catch (NoSuchFieldException e) {
                // agar koi field class me na ho to ignore kar do
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Narayan");
        map.put("age", 23);
        map.put("department", "IT");

        Employee emp = toObject(Employee.class, map);

        System.out.println("Employee Info:");
        System.out.println("Name = " + emp.name);
        System.out.println("Age = " + emp.age);
        System.out.println("Department = " + emp.department);
    }
}

