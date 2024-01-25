package com.rajesh.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {
    // constant string values
    private static final String INPUT_DECORATIVE_STRING = "*********************** INPUT ***********************";
    static final String END_DECORATIVE_STRING = "************************ END ************************";

    // private constructor
    private InputHelper() {
    }

    // BufferedReader instance to read user input
    private static BufferedReader userInputReader;

    /**
     * method to initialize BufferedReader instance, which is used to read user
     * inputs from terminal
     */
    public static void initializeUserInputReader() {
        // check if BufferedReader instance has not been initialized already
        if (InputHelper.userInputReader == null) {
            // initialize BufferedReader instance
            InputHelper.userInputReader = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    /**
     * method to read user input to set the level (EASY/MEDIUM/HARD) of the game.
     * 
     * @return corresponding integer value of the level of the game
     */
    static int getUserInputForGameLevel() {
        // show introduction text related to game levels
        System.out.println("********************* SET LEVEL *********************");
        System.out.println("* SET THE LEVEL OF THE GAME FROM THE BELOW LIST --> *");
        System.out.println("* 1. EASY                                           *");
        System.out.println("* 2. MEDIUM                                         *");
        System.out.println("* 3. HARD                                           *");

        // ask user for input
        System.out.println(INPUT_DECORATIVE_STRING);
        System.out.print("* SET YOUR LEVEL (1/2/3) --> ");

        try {
            // read user input
            String userInput = InputHelper.userInputReader.readLine();

            // check if user input is invalid
            if (!userInput.trim().equals("1") && !userInput.trim().equals("2") && !userInput.trim().equals("3")) {
                // show error message and again ask for user input
                System.err.println("* INVALID LEVEL VALUE!                              *");
                System.out.println(END_DECORATIVE_STRING);
                return InputHelper.getUserInputForGameLevel();
            }
            else {
                // return game level value set by user as an integer
                System.out.println(END_DECORATIVE_STRING);
                return Integer.parseInt(userInput);
            }
        }
        catch (IOException e) {
            // show error message and again ask for user input
            System.err.println("* SOME INTERNAL ERROR OCCURRED!                     *");
            System.out.println(END_DECORATIVE_STRING);
            return InputHelper.getUserInputForGameLevel();
        }
    }

    /**
     * method to read user input for lower limit value of the range that will be
     * used for the number guessing game.
     * 
     * @return lower limit value of the range as an integer
     */
    static int getUserInputForLowerRangeLimit() {
        // show introduction text related to the lower limit of the range
        System.out.println("*************** SET LOWER RANGE LIMIT ***************");
        System.out.println("* ENTER THE LOWER LIMIT OF THE RANGE FOLLOWING THE  *");
        System.out.println("* GIVEN RULES -->                                   *");
        System.out.println("* 1. THE VALUE HAS TO BE A NUMERIC VALUE            *");
        System.out.println("* 2. THE VALUE HAS TO BE AN INTEGER                 *");

        // ask user for input
        System.out.println(INPUT_DECORATIVE_STRING);
        System.out.print("* ENTER LOWER RANGE LIMIT --> ");

        try {
            // read user input and parse the value as an integer
            int lowerRangeLimitValue = Integer.parseInt(InputHelper.userInputReader.readLine());

            // return lower range limit value
            System.out.println(END_DECORATIVE_STRING);
            return lowerRangeLimitValue;
        }
        catch (IOException | NumberFormatException e) {
            // show error message and again ask for user input
            System.err.println("* INVALID INPUT FOR LOWER RANGE LIMIT!              *");
            System.out.println(END_DECORATIVE_STRING);
            return InputHelper.getUserInputForLowerRangeLimit();
        }
    }

    /**
     * method to read user input for upper limit value of the range that will be
     * used for the number guessing game. The upper limit value has to be greater
     * than the lower limit value and they should have at least a gap of 10 digits.
     * 
     * @return upper limit value of the range as an integer
     */
    static int getUserInputForUpperRangeLimit(int lowerRangeLimitValue) {
        // show introduction text related to the lower limit of the range
        System.out.println("*************** SET UPPER RANGE LIMIT ***************");
        System.out.println("* ENTER THE UPPER LIMIT OF THE RANGE FOLLOWING THE  *");
        System.out.println("* GIVEN RULES -->                                   *");
        System.out.println("* 1. THE VALUE HAS TO BE A NUMERIC VALUE            *");
        System.out.println("* 2. THE VALUE HAS TO BE AN INTEGER                 *");
        System.out.println("* 3. THE VALUE HAS TO BE GREATER THAN THE LOWER     *");
        System.out.println("*    RANGE LIMIT.                                   *");
        System.out.println("* 4. THE UPPER AND LOWER RANGE LIMIT VALUE MUST     *");
        System.out.println("*    HAVE A GAP OF AT LEAST 10 DIGITS.              *");

        // ask user for input
        System.out.println(INPUT_DECORATIVE_STRING);
        System.out.print("* ENTER UPPER RANGE LIMIT --> ");

        try {
            // read user input and parse the value as an integer
            int upperRangeLimit = Integer.parseInt(InputHelper.userInputReader.readLine());

            // verify if the upper range limit is greater than the lower range limit
            // verify if the upper range limit and the lower range limit has a gap of
            // at least 10 digits
            if (upperRangeLimit > lowerRangeLimitValue && (upperRangeLimit - lowerRangeLimitValue) > 10) {
                // return upper range limit
                System.out.println(END_DECORATIVE_STRING);
                return upperRangeLimit;
            }
            else {
                // show error message and again ask for user input
                System.err.println("* INVALID INPUT FOR UPPER RANGE LIMIT!              *");
                System.out.println(END_DECORATIVE_STRING);
                return InputHelper.getUserInputForUpperRangeLimit(lowerRangeLimitValue);
            }
        }
        catch (IOException | NumberFormatException e) {
            // show error message and again ask for user input
            System.err.println("* INVALID INPUT FOR UPPER RANGE LIMIT!              *");
            System.out.println(END_DECORATIVE_STRING);
            return InputHelper.getUserInputForUpperRangeLimit(lowerRangeLimitValue);
        }
    }

    /**
     * method to read user input for the number guessed by the user
     * 
     * @return number guessed by user as a String
     */
    static int getUserInputForGuessedNumber() {
        System.out.println(INPUT_DECORATIVE_STRING);
        System.out.print("* ENTER YOUR GUESS --> ");

        try {
            // read user input and parse as an integer
            int guessedNumber = Integer.parseInt(InputHelper.userInputReader.readLine());

            // return number guessed by user
            System.out.println(InputHelper.END_DECORATIVE_STRING);
            return guessedNumber;
        }
        catch (IOException | NumberFormatException e) {
            // show error message and again ask for user input
            System.err.println("* INVALID LEVEL VALUE!                              *");
            System.out.println(InputHelper.END_DECORATIVE_STRING);
            return InputHelper.getUserInputForGuessedNumber();
        }

    }
}
