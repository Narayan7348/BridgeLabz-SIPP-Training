import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Narayan Rajpoot")
class Book {}

public class AnnotationExample {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}
