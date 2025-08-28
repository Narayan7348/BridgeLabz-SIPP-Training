// TaskTest.java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
public class TaskTest {
    Task t=new Task();
    @Test
    @Timeout(2)
    void testTimeout(){ assertEquals("done",t.longRunningTask()); }
}

