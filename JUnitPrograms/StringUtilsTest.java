// StringUtilsTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringUtilsTest {
    StringUtils u=new StringUtils();
    @Test void testReverse(){ assertEquals("cba",u.reverse("abc")); }
    @Test void testPalindrome(){ assertTrue(u.isPalindrome("madam")); }
    @Test void testUpper(){ assertEquals("HELLO",u.toUpperCase("hello")); }
}
