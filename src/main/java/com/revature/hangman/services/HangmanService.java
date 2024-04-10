package com.revature.hangman.services;

import java.util.Random;

/**
 * Provides functionality for playing the Hangman game. It includes picking a
 * word at random for the player to guess,
 * masking the word, updating guesses, and checking if a guess is correct or
 * valid.
 */
public class HangmanService {
    private final Random rand;

    /**
     * Initializes a new HangmanService. This service needs a source of randomness
     * to pick words.
     *
     * @param rand A Random instance for generating random numbers (used to pick
     *             words randomly).
     */
    public HangmanService(Random rand) {
        this.rand = rand;
    }

    /**
     * Picks a word randomly from a list of words like "Java", "SQL", "PEGA",
     * "Coding".
     *
     * @return The word chosen at random. Think of it as the game secretly choosing
     *         a word for you to guess.
     */
    public String getRandomWord() {
        String[] words = { "Java", "SQL", "PEGA", "Coding" };
        return words[rand.nextInt(words.length)];
    }

    /**
     * Turns every letter of the given word into an asterisk (*). It's like a
     * disguise for the word.
     * 
     * Example: Java => ****
     *
     * @param word The word you're trying to guess in the game.
     * @return A string of asterisks (*) hiding each letter of the original word.
     */
    public String maskWord(String word) {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Reveals the correct guesses in the masked word. For example, if the actual
     * word is "code" and you guess "e",
     * it changes "****" to "***e".
     *
     * @param word       The actual word you're trying to guess.
     * @param maskedWord The word with some or all letters hidden by asterisks,
     *                   based on your previous guesses.
     * @param userInput  What you guess the letter might be.
     * @return An updated version of the masked word with your correct guess
     *         revealed.
     */
    public String updateWord(String word, String maskedWord, String userInput) {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Checks if the letter you guessed is in the word.
     *
     * @param word      The word you're trying to guess.
     * @param userInput Your guess - the letter you think might be in the word.
     * @return True if your guess is right (the letter is in the word); False if
     *         it's not.
     */
    public boolean isCorrectGuess(String word, String userInput) {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Makes sure your guess is a single letter. Anything more than one letter, or
     * not a letter at all, is not allowed.
     *
     * @param userInput What you're guessing - supposed to be just one letter.
     * @return True if your guess is a single letter; False if it's more than one
     *         letter or not a letter.
     */
    public boolean isValidGuess(String userInput) {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Checks if a guess is unique compared to previous guesses.
     *
     * This method looks through all your previous guesses to see if you've already
     * guessed
     * the letter you're thinking of now. It's a way to avoid repeating guesses.
     *
     * @param userInput The letter you're guessing right now.
     * @param guesses   An array containing all the letters you've guessed so far.
     * @return True if the letter hasn't been guessed before; False if it has.
     */
    public boolean isUniqueGuess(String userInput, char[] guesses) {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Prepares an array to track your guesses.
     *
     * At the start of the game, this sets up an array filled with spaces. Each
     * space represents a slot for a future guess. There are 26 slots, one for each
     * letter of the alphabet.
     *
     * @return An array of 26 spaces, ready to be filled with your guesses.
     */
    public char[] initializeGuesses() {
        throw new RuntimeException("TODO! Needs implementation...");
    }

    /**
     * Adds your latest guess to the list of guesses.
     *
     * When you make a guess, this method puts that letter into the first open slot
     * in your guesses array. It helps keep track of all the letters you've guessed
     * throughout the game.
     *
     * @param guesses   The current list of guesses, some of which may already be
     *                  filled in.
     * @param userInput The letter you're guessing now.
     * @return The updated list of guesses, including your latest guess.
     */
    public char[] updateGuesses(char[] guesses, String userInput) {
        throw new RuntimeException("TODO! Needs implementation...");
    }
}
