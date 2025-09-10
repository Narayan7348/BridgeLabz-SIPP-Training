import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paragraph = sc.nextLine();
        String[] words = paragraph.toLowerCase().split("\\s+");
        Map<String, Long> frequency = Arrays.stream(words)
                .collect(Collectors.groupingBy(w->w, Collectors.counting()));
        System.out.println(frequency);
    }
}

