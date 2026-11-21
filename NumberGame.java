
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String choice;

        System.out.println("Welcome to Number Guessing Game!");

        do {

            // Generate a random number
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean won = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have 7 chances to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {

                    System.out.println("That's correct! You guessed it!");
                    System.out.println("You took " + attempts + " attempts.");

                    int points = (maxAttempts - attempts + 1) * 10;
                    score = score + points;

                    System.out.println("You earned " + points + " points.");
                    won = true;
                    break;

                } else if (guess < number) {

                    System.out.println("Your guess is too low. Try again!");

                } else {

                    System.out.println("Your guess is too high. Try again!");

                }
            }

            if (!won) {
                System.out.println("\nSorry! You have used all your chances.");
                System.out.println("The correct number was " + number);
            }

            System.out.println("Your total score is: " + score);

            System.out.print("\nWould you like to play again? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\nThanks for playing!");
        System.out.println("Your final score is: " + score);

        sc.close();
    }
}
