package com.revature.hangman;

import java.util.Random;
import java.util.Scanner;

import com.revature.hangman.models.Player;
import com.revature.hangman.screens.HangmanScreen;
import com.revature.hangman.services.HangmanService;

public class Main {
    public static void main(String[] args) {
        // For getting user input
        Scanner scan = new Scanner(System.in);

        // For handling hangman validation logics
        Random rand = new Random(); // For generating a random number
        HangmanService hangmanService = new HangmanService(rand);

        // Player obj
        // TODO: set the player's life
        Player player = null;

        // Hangman Object
        // Dependent on HangmanService, Player and Scanner
        HangmanScreen hangman = new HangmanScreen(hangmanService, player, scan);
        hangman.startGame(); // start the game

        // Close the scanner when the game is done
        scan.close();
    }
}