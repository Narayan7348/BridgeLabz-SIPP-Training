import java.util.*;



class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class QuizResultProcessor {

   
    static String[] correctAnswers = {"A", "B", "C", "D", "A"};
    

    static List<Integer> scores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("--- Online Quiz ---");
            System.out.println("Please enter your answers (A/B/C/D):");

          
            String[] userAnswers = new String[correctAnswers.length];
            for (int i = 0; i < correctAnswers.length; i++) {
                System.out.print("Q" + (i + 1) + ": ");
                userAnswers[i] = scanner.nextLine().toUpperCase();
            }

          
            int score = calculateScore(userAnswers);
            String grade = getGrade(score);

            scores.add(score); 
            System.out.println("Your Score: " + score + "/" + correctAnswers.length);
            System.out.println("Your Grade: " + grade);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAll User Scores: " + scores);
    }

   
    public static int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer count does not match the number of questions.");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    
    public static String getGrade(int score) {
        int total = correctAnswers.length;
        double percentage = (score * 100.0) / total;

        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 50) return "C";
        else return "F";
    }
}
