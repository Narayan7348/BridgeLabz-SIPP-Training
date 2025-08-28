// Divider.java
import java.util.Scanner;
public class Divider {
    public int divide(int a,int b){
        if(b==0) throw new ArithmeticException("Division by zero");
        return a/b;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        Divider d=new Divider();
        System.out.println(d.divide(a,b));
    }
}

