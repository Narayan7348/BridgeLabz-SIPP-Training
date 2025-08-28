// DividerTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DividerTest {
    Divider d=new Divider();
    @Test void testDivide(){ assertEquals(2,d.divide(6,3)); }
    @Test void testDivideZero(){ assertThrows(ArithmeticException.class,()->d.divide(5,0)); }
}
