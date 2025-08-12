import java.util.*;
import java.util.regex.*;
public class FindRepeatingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Matcher m = Pattern.compile("\\b(\\w+)\\s+\\1\\b").matcher(text);
        while (m.find()) System.out.println(m.group(1));
    }
}
