import java.util.*;
public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(text.replaceAll("\\s+", " "));
    }
}

