import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result...");
            return cache.get(n);
        }
        System.out.println("Computing square for " + n);
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}

public class CacheResultExample {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();

        System.out.println(service.computeSquare(5)); // first time, compute
        System.out.println(service.computeSquare(5)); // second time, cached
        System.out.println(service.computeSquare(10)); // new compute
    }
}
