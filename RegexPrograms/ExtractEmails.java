import java.util.*;
import java.util.regex.*;
public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Matcher m = Pattern.compile("[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}").matcher(text);
        while (m.find()) System.out.println(m.group());
    }
}

