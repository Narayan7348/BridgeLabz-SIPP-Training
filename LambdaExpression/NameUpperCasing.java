import java.util.*;

class NameUpperCasing {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("raj", "simran", "amit");
        employees.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
