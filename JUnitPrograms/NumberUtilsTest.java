// NumberUtilsTest.java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class NumberUtilsTest {
    NumberUtils u=new NumberUtils();
    @ParameterizedTest
    @ValueSource(ints={2,4,6})
    void testEvenNumbers(int n){ assertTrue(u.isEven(n)); }
    @ParameterizedTest
    @ValueSource(ints={7,9,11})
    void testOddNumbers(int n){ assertFalse(u.isEven(n)); }
}
