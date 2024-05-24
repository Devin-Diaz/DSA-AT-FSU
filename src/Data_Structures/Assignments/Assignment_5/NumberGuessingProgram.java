package Data_Structures.Assignments.Assignment_5;

//Name: Devin Diaz
//Time: March. 31, 2024
//Class: Data Structures
//Instructor: Jeff Gao
/*Pledge: I, Devin Diaz, did not receive any help for this
programming assignment.*/

import java.util.Scanner;

/*
    In this program the user will choose a number between the range 0 - 200 inclusive. From here the program will
    attempt to guess the user's number. On each guess the program will prompt whether it's guess is higher
    or lower than the user's chosen number. Assuming the user answers truthfully, (yes or no), the program will adjust
    its search bounds with a binary search technique as it gets closer to the bounds of the user's chosen number. Upon
    choosing the correct number, the user will notify the program that it has guessed correctly
*/
public class NumberGuessingProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameState = true;

        while (gameState) {
            int low = 0;
            int high = 200;
            int guess;
            System.out.println("THINK OF A NUMBER 0 - 200 INCLUSIVE. I WILL ATTEMPT TO GUESS IT.");
            System.out.println("RESPOND WITH 'higher', 'lower', or 'correct' TO GUIDE ME.");

            while (true) {
                guess = low + (high - low) / 2;
                System.out.print("Is your number " + guess + "? ");
                String input = sc.nextLine().trim().toLowerCase();

                if ("higher".equals(input)) {
                    low = guess + 1;
                }
                else if ("lower".equals(input)) {
                    high = guess - 1;
                }
                else if ("correct".equals(input)) {
                    System.out.println("I GUESSED YOUR NUMBER CORRECTLY!");
                    break;
                }
                else {
                    System.out.println("PLEASE RESPOND TRUTHFULLY W/ 'higher', 'lower', or 'correct'.");
                }

                if (low > high) {
                    System.out.println("MISUNDERSTANDING. LET'S START OVER.");
                    break;
                }
            }

            System.out.println("DO YOU WANT TO PLAY AGAIN? (Y/N)");
            String playAgainInput = sc.nextLine().trim().toLowerCase();
            if (!"y".equalsIgnoreCase(playAgainInput)) {
                gameState = false;
                System.out.println("THANKS FOR PLAYING!!");
            }
        }
    }
}
