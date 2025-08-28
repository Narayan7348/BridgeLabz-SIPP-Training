// FileProcessorTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
public class FileProcessorTest {
    FileProcessor f=new FileProcessor();
    @Test void testWriteRead()throws Exception{
        f.writeToFile("test.txt","hello");
        assertEquals("hello",f.readFromFile("test.txt"));
    }
    @Test void testFileExists()throws Exception{
        f.writeToFile("test2.txt","data");
        File file=new File("test2.txt");
        assertTrue(file.exists());
    }
    @Test void testFileNotFound(){
        assertThrows(IOException.class,()->f.readFromFile("nofile.txt"));
    }
}
