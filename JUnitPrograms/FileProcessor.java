// FileProcessor.java
import java.io.*;
import java.util.Scanner;
public class FileProcessor {
    public void writeToFile(String filename,String content)throws IOException{
        FileWriter fw=new FileWriter(filename);
        fw.write(content);
        fw.close();
    }
    public String readFromFile(String filename)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String s=br.readLine(); br.close(); return s;
    }
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        String file=sc.next(),content=sc.next();
        FileProcessor f=new FileProcessor();
        f.writeToFile(file,content);
        System.out.println(f.readFromFile(file));
    }
}
