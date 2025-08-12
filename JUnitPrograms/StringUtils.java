import java.util.Scanner;

public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringUtils util = new StringUtils();
        String s = sc.nextLine();
        System.out.println(util.reverse(s));
        System.out.println(util.isPalindrome(s));
        System.out.println(util.toUpperCase(s));
    }
}
