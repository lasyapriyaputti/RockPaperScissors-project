import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Rock-Paper-Scissors Game ");
        System.out.print("Enter number of rounds you want to play: ");
        int rounds = sc.nextInt();

        int userScore = 0, compScore = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i + " of " + rounds);
            System.out.println("Choose: 1 for Rock, 2 for Paper, 3 for Scissors");
            System.out.print("Your choice: ");
            int userChoice = sc.nextInt();

            // Validate input
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                i--; // repeat the round
                continue;
            }

            int compChoice = rand.nextInt(3) + 1;

            // Display choices
            System.out.println("You chose: " + choiceName(userChoice));
            System.out.println("Computer chose: " + choiceName(compChoice));

            // Decide winner
            if (userChoice == compChoice) {
                System.out.println("It's a draw!");
            } else if ((userChoice == 1 && compChoice == 3) ||
                       (userChoice == 2 && compChoice == 1) ||
                       (userChoice == 3 && compChoice == 2)) {
                System.out.println("You win this round! ");
                userScore++;
            } else {
                System.out.println("Computer wins this round! ");
                compScore++;
            }

            System.out.println("Current Score -> You: " + userScore + " | Computer: " + compScore);
        }

        // Final result
        System.out.println("\nFinal Score -> You: " + userScore + " | Computer: " + compScore);
        if (userScore > compScore) {
            System.out.println(" Congratulations! You are the Winner!");
        } else if (compScore > userScore) {
            System.out.println("Computer Wins the Game! Better luck next time.");
        } else {
            System.out.println("It's a Tie Overall!");
        }

        sc.close();
    }

    // Helper method to convert number to name
    private static String choiceName(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
        }
        return "";
    }
}
