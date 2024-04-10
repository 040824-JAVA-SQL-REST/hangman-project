package com.revature.hangman.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class HangmanServiceTest {
    private Random rand;
    private HangmanService hangmanService;

    @Before
    public void setup() {
        rand = mock(Random.class);
        hangmanService = new HangmanService(rand);
    }

    @Test
    public void testGetRandomWordShouldReturnCoding() {
        // ARRANGE
        String[] words = { "Java", "SQL", "PEGA", "Coding" };

        int index = 3;
        when(rand.nextInt(words.length)).thenReturn(index);

        // ACT
        String actual = hangmanService.getRandomWord();

        // ASSERT
        assertEquals("Coding", actual);
    }

    @Test
    public void testGetRandomWordShouldReturnJava() {
        // ARRANGE
        String[] words = { "Java", "SQL", "PEGA", "Coding" };

        int index = 0;
        when(rand.nextInt(words.length)).thenReturn(index);

        // ACT
        String actual = hangmanService.getRandomWord();

        // ASSERT
        assertEquals("Java", actual);
    }

    @Test
    public void testGetRandomWordShouldReturnSQL() {
        // ARRANGE
        String[] words = { "Java", "SQL", "PEGA", "Coding" };

        int index = 1;
        when(rand.nextInt(words.length)).thenReturn(index);

        // ACT
        String actual = hangmanService.getRandomWord();

        // ASSERT
        assertEquals("SQL", actual);
    }

    @Test
    public void testGetRandomWordShouldReturnPEGA() {
        // ARRANGE
        String[] words = { "Java", "SQL", "PEGA", "Coding" };

        int index = 2;
        when(rand.nextInt(words.length)).thenReturn(index);

        // ACT
        String actual = hangmanService.getRandomWord();

        // ASSERT
        assertEquals("PEGA", actual);
    }

    @Test
    public void testMaskWordCase1() {
        // ARRANGE
        String word = "abcdeabcde";

        // ACT
        String actual = hangmanService.maskWord(word);

        // ASSERT
        assertEquals("**********", actual);
        assertEquals(10, actual.length());
    }

    @Test
    public void testMaskWordCase2() {
        // ARRANGE
        String word = "a";

        // ACT
        String actual = hangmanService.maskWord(word);

        // ASSERT
        assertEquals("*", actual);
        assertEquals(1, actual.length());
    }

    @Test
    public void testMaskWordCase3() {
        // ARRANGE
        String word = "";

        // ACT
        String actual = hangmanService.maskWord(word);

        // ASSERT
        assertEquals("", actual);
        assertEquals(0, actual.length());
    }

    @Test
    public void testUpdateWordCase1() {
        // ARRANGE
        String word = "Java";
        String maskedWord = "****";
        String userInput = "j";

        // ACT
        String actual = hangmanService.updateWord(word, maskedWord, userInput);

        // ASSERT
        assertEquals("j***", actual);
    }

    @Test
    public void testUpdateWordCase2() {
        // ARRANGE
        String word = "Java";
        String maskedWord = "****";
        String userInput = "a";

        // ACT
        String actual = hangmanService.updateWord(word, maskedWord, userInput);

        // ASSERT
        assertEquals("*a*a", actual);
    }

    @Test
    public void testUpdateWordCase3() {
        // ARRANGE
        String word = "Java";
        String maskedWord = "****";
        String userInput = "z";

        // ACT
        String actual = hangmanService.updateWord(word, maskedWord, userInput);

        // ASSERT
        assertEquals("****", actual);
    }

    @Test
    public void testUpdateWordCase4() {
        // ARRANGE
        String word = "Java";
        String maskedWord = "j***";
        String userInput = "a";

        // ACT
        String actual = hangmanService.updateWord(word, maskedWord, userInput);

        // ASSERT
        assertEquals("ja*a", actual);
    }

    @Test
    public void testIsCorrectGuessCase1() {
        // ARRANGE
        String word = "Java";
        String userInput = "a";

        // ACT
        boolean actual = hangmanService.isCorrectGuess(word, userInput);

        // ASSERT
        assertTrue(actual);
    }

    @Test
    public void testIsCorrectGuessCase2() {
        // ARRANGE
        String word = "SQL";
        String userInput = "a";

        // ACT
        boolean actual = hangmanService.isCorrectGuess(word, userInput);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testIsCorrectGuessCase3() {
        // ARRANGE
        String word = "SQL";
        String userInput = "s";

        // ACT
        boolean actual = hangmanService.isCorrectGuess(word, userInput);

        // ASSERT
        assertTrue(actual);
    }

    @Test
    public void testIsValidGuessCase1() {
        // ARRANGE
        String userInput = "a";

        // ACT
        boolean actual = hangmanService.isValidGuess(userInput);

        // ASSERT
        assertTrue(actual);
    }

    @Test
    public void testIsValidGuessCase2() {
        // ARRANGE
        String userInput = "1";

        // ACT
        boolean actual = hangmanService.isValidGuess(userInput);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testIsValidGuessCase3() {
        // ARRANGE
        String userInput = "ab";

        // ACT
        boolean actual = hangmanService.isValidGuess(userInput);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testIsValidGuessCase4() {
        // ARRANGE
        String userInput = "12!";

        // ACT
        boolean actual = hangmanService.isValidGuess(userInput);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testIsValidGuessCase5() {
        // ARRANGE
        String userInput = "J";

        // ACT
        boolean actual = hangmanService.isValidGuess(userInput);

        // ASSERT
        assertTrue(actual);
    }

    @Test
    public void testIsUniqueGuessCase1() {
        // ARRANGE
        char[] guesses = new char[26];
        for (int i = 0; i < guesses.length; i++) {
            guesses[i] = ' ';
        }

        String userInput = "j";

        // ACT
        boolean actual = hangmanService.isUniqueGuess(userInput, guesses);

        // ASSERT
        assertTrue(actual);
    }

    @Test
    public void testIsUniqueGuessCase2() {
        // ARRANGE
        char[] guesses = new char[26];
        guesses[0] = 'j';

        String userInput = "j";

        // ACT
        boolean actual = hangmanService.isUniqueGuess(userInput, guesses);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testIsUniqueGuessCase3() {
        // ARRANGE
        char[] guesses = new char[26];
        guesses[0] = 'j';
        guesses[1] = 'a';

        String userInput = "a";

        // ACT
        boolean actual = hangmanService.isUniqueGuess(userInput, guesses);

        // ASSERT
        assertFalse(actual);
    }

    @Test
    public void testInitializeGuesses() {
        // ACT
        char[] actual = hangmanService.initializeGuesses();

        // ASSERT
        char[] expected = { ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' ', ' ', ' '
        };

        assertArrayEquals(expected, actual);
        assertEquals(expected.length, actual.length);
    }

    @Test
    public void testUpdateGuessesCase1() {
        // ARRANGE
        char[] guesses = { ' ' };
        String userInput = "a";

        // ACT
        char[] actual = hangmanService.updateGuesses(guesses, userInput);

        // ASSERT
        char[] expected = { 'a' };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testUpdateGuessesCase2() {
        // ARRANGE
        char[] guesses = { 'a', ' ' };
        String userInput = "j";

        // ACT
        char[] actual = hangmanService.updateGuesses(guesses, userInput);

        // ASSERT
        char[] expected = { 'a', 'j' };
        assertArrayEquals(expected, actual);
    }
}
