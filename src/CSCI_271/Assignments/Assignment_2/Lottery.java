package CSCI_271.Assignments.Assignment_2;

import java.util.Random;
import java.util.Scanner;

/**
 * This class simulates a lottery game where users can enter guessed numbers and try to match a randomly drawn number.
 * If they guess correctly, the prize money is divided among the winners. Users can play multiple rounds of the game until they choose to exit.
 */
public class Lottery {

    /**
     * Main method to start the lottery game.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        startLottery();
    }

    /**
     * This method manages the game state, allowing the user to play multiple rounds of the lottery game until they decide to stop.
     */
    private static void startLottery() {
        Scanner sc = new Scanner(System.in);
        boolean gameState = true;
        while (gameState) {
            playLottery();
            System.out.print("\nWould you like to play the lottery again? (y/n) ");
            String userAns = sc.nextLine();
            if (userAns.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                gameState = false;
            }
        }
    }

    /**
     * This method controls a single round of the lottery game. It collects user entries, determines a winner, and calculates prize distribution.
     */
    private static void playLottery() {
        System.out.println("""
                Let's play a lottery! The prize is $4000. If there are multiple winners,
                the prize will be split evenly among the winners. The range of the lottery is from 1 - 100. An entry of -1
                signifies the end of entries. Let's begin!
                """);

        int prizeMoney = 4000;
        Scanner sc = new Scanner(System.in);
        Bag bag = new Bag();

        System.out.print("Enter guess: ");
        while (sc.hasNextInt()) {
            int lotteryEntry = sc.nextInt();
            if (lotteryEntry == -1) break;
            bag.add(lotteryEntry);
            System.out.print("Enter guess: ");
        }
        if (bag.isEmpty()) {
            System.out.println("No guesses have been made. End of lottery. Thanks for playing!");
            return;
        }

        Random r = new Random();
        int winningNumber = r.nextInt(100) + 1; // Ensures range is 1-100

        if (!bag.contains(winningNumber)) {
            System.out.println("No winner in this lottery. Thanks for playing!");
            return;
        }

        int totalWinners = bag.occurrences(winningNumber);
        double prizeMoneyWon = (double) prizeMoney / totalWinners;

        System.out.println("The random number in the lottery was...." + winningNumber +
                "\nThere was a total of " + totalWinners + " winner(s). The prize for the winner(s) is " +
                "$" + prizeMoneyWon + "!\nThanks for playing!");
    }

}
