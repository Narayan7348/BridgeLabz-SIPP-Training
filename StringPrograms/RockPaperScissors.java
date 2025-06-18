import java.util.*;

public class RockPaperScissors {
    
    // Method to get computer choice
    private static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        switch(choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }
    
    // Method to determine winner
    private static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) return "Tie";
        
        switch(playerChoice) {
            case "rock":
                return (computerChoice.equals("scissors")) ? "Player" : "Computer";
            case "paper":
                return (computerChoice.equals("rock")) ? "Player" : "Computer";
            case "scissors":
                return (computerChoice.equals("paper")) ? "Player" : "Computer";
            default:
                return "Invalid";
        }
    }
    
    // Method to calculate statistics
    private static String[][] calculateStats(int playerWins, int computerWins, int games) {
        double playerPercent = (playerWins * 100.0) / games;
        double computerPercent = (computerWins * 100.0) / games;
        
        return new String[][] {
            {"Player", String.valueOf(playerWins), String.format("%.2f%%", playerPercent)},
            {"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerPercent)}
        };
    }
    
    // Method to display results
    private static void displayResults(String[][] stats) {
        System.out.println("\nFinal Statistics:");
        System.out.println("Player   | Wins | Win Percentage");
        System.out.println("---------|------|---------------");
        for (String[] row : stats) {
            System.out.printf("%-8s | %-4s | %s%n", row[0], row[1], row[2]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of games to play: ");
        int games = scanner.nextInt();
        
        int playerWins = 0, computerWins = 0;
        
        for (int i = 1; i <= games; i++) {
            System.out.println("\nGame " + i);
            System.out.println("Enter your choice (rock/paper/scissors): ");
            String playerChoice = scanner.next().toLowerCase();
            String computerChoice = getComputerChoice();
            
            System.out.println("Computer chose: " + computerChoice);
            String winner = findWinner(playerChoice, computerChoice);
            
            if (winner.equals("Player")) playerWins++;
            else if (winner.equals("Computer")) computerWins++;
            
            System.out.println("Result: " + winner);
        }
        
        displayResults(calculateStats(playerWins, computerWins, games));
        scanner.close();
    }
}