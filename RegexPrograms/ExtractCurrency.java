import java.util.*;
import java.util.regex.*;
public class ExtractCurrency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Matcher m = Pattern.compile("\\$\\d+\\.\\d{2}|\\b\\d+\\.\\d{2}\\b").matcher(text);
        while (m.find()) System.out.println(m.group());
    }
}

