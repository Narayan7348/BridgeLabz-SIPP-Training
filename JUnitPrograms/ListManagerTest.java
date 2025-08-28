// ListManagerTest.java
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class ListManagerTest {
    ListManager m=new ListManager();
    @Test void testAdd(){ List<Integer> l=new ArrayList<>(); m.addElement(l,5); assertTrue(l.contains(5)); }
    @Test void testRemove(){ List<Integer> l=new ArrayList<>(Arrays.asList(1,2,3)); m.removeElement(l,2); assertFalse(l.contains(2)); }
    @Test void testSize(){ List<Integer> l=new ArrayList<>(); m.addElement(l,1); assertEquals(1,m.getSize(l)); }
}

