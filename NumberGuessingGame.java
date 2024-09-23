import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 7; // Limiting attempts to 7
            boolean roundWon = false;

            System.out.println("I have selected a number between 1 and 100. You have 7 attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!roundWon) {
                System.out.println("You've used all attempts! The correct number was: " + numberToGuess);
            }

            roundsPlayed++;

            // Asking the player if they want to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        // Display the final score
        System.out.println("Game Over! You played " + roundsPlayed + " round(s) and won " + roundsWon + " round(s).");
        System.out.println("Thank you for playing!");
    }
}
