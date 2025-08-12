import java.util.*;
import java.util.regex.*;
public class  ExtractDates{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (m.find()) System.out.println(m.group());
    }
}
