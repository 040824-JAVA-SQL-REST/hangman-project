package com.revature.hangman.screens;

import java.util.Scanner;

import com.revature.hangman.models.Player;
import com.revature.hangman.services.HangmanService;

public class HangmanScreen {
    private final HangmanService hangmanService;
    private Player player;
    private final Scanner scan;

    public HangmanScreen(HangmanService hangmanService, Player player, Scanner scan) {
        this.hangmanService = hangmanService;
        this.player = player;
        this.scan = scan;
    }

    public void startGame() {
        char[] guesses = hangmanService.initializeGuesses();
        String userInput = "";
        String word = hangmanService.getRandomWord();
        String maskedWord = hangmanService.maskWord(word);

        if (player == null || player.getLife() <= 0) {
            clearConsole();
            System.out.println("Please set the player's life to play Hangman!");
            System.out.println("\nYou can do it Main.java");
            pressEnterToContinue(scan);
            return;
        }

        while (player.getLife() > 0) {
            if (maskedWord.equalsIgnoreCase(word)) {
                break;
            }

            clearConsole();
            System.out.println("########## Welcome to Hangman ##########\n");
            System.out.println("Life: " + player.getLife());
            System.out.println("Word to guess: " + maskedWord);
            System.out.println("\nguesses: " + displayGuesses(guesses));
            System.out.print("\nEnter: ");
            userInput = scan.nextLine();

            if (!hangmanService.isValidGuess(userInput)) {
                clearConsole();
                System.out.println("Please enter a valid guess (single char a-z)");
                pressEnterToContinue(scan);
                continue;
            }

            if (!hangmanService.isUniqueGuess(userInput, guesses)) {
                clearConsole();
                System.out.println("You already made this guess");
                pressEnterToContinue(scan);
                continue;
            }

            if (!hangmanService.isCorrectGuess(word, userInput)) {
                guesses = hangmanService.updateGuesses(guesses, userInput);
                clearConsole();
                System.out.println("Incorrect guess!");
                player.setLife(player.getLife() - 1);
                pressEnterToContinue(scan);
                continue;
            }

            clearConsole();
            System.out.println("Correct guess!");
            pressEnterToContinue(scan);
            maskedWord = hangmanService.updateWord(word, maskedWord, userInput);
            guesses = hangmanService.updateGuesses(guesses, userInput);
        }

        clearConsole();
        System.out.println(player.getLife() == 0 ? "You lose!" : "You win!");
        System.out.println("The word to guess was: " + word);
        pressEnterToContinue(scan);
    }

    /*
     * ############################## Helper methods ##############################
     */

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pressEnterToContinue(Scanner scan) {
        System.out.print("\nPress enter to continue...");
        scan.nextLine();
    }

    private String displayGuesses(char[] guesses) {
        StringBuilder sb = new StringBuilder("[");
        boolean firstCharAdded = false;
        for (char c : guesses) {
            if (c != ' ') {
                if (firstCharAdded) {
                    sb.append(", ");
                }
                sb.append(c);
                firstCharAdded = true;
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
