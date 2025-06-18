import java.util.*;

public class StudentVotingEligibility {
    
    
    private static int[] generateStudentAges(int count) {
        int[] ages = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            ages[i] = random.nextInt(90) + 10; 
        }
        return ages;
    }
    
    
    private static String[][] checkVotingEligibility(int[] ages) {
        String[][] results = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            results[i][0] = String.valueOf(ages[i]);
            results[i][1] = (ages[i] >= 18 && ages[i] >= 0) ? "true" : "false";
        }
        return results;
    }
    
    
    private static void displayResults(String[][] results) {
        System.out.println("Age | Can Vote");
        System.out.println("----|----------");
        for (String[] result : results) {
            System.out.printf("%-3s | %-8s%n", result[0], result[1]);
        }
    }
    
    public static void main(String[] args) {
        int studentCount = 10;
        int[] ages = generateStudentAges(studentCount);
        String[][] votingEligibility = checkVotingEligibility(ages);
        
        System.out.println("Student Voting Eligibility Results:");
        displayResults(votingEligibility);
    }
}