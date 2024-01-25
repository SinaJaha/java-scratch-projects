package com.rajesh.helpers;

public class GameHelper {
    private static int gameLevel;
    private static int numberOfChances;
    private static int randomNumber;

    private static final String DIVIDER_DECORATIVE_LINE = "*    *********************************************  *";

    // private constructor
    private GameHelper() {
    }

    private static void showIntroduction() {
        System.out.println("*********************** START ***********************");
        System.out.println("*               NUMBER GUESSING GAME                *");
        System.out.println("*****************************************************");
        System.out.println("* This is a simple console based number guessing    *");
        System.out.println("* game, which has been developed using Java.        *");
        System.out.println("******************** INFORMATION ********************");
        System.out.println("* DEVELOPER: Rajesh Sinha                           *");
        System.out.println("* EMAIL: rajeshsinha97@outlook.com                  *");
        System.out.println("*********************** RULES ***********************");
        System.out.println("* 1. The user first has to choose a difficulty      *");
        System.out.println("*    level as per choice. The possible options are  *");
        System.out.println("*    EASY or MEDIUM or HARD.                        *");
        System.out.println(GameHelper.DIVIDER_DECORATIVE_LINE);
        System.out.println("* 2. Next the user will be asked to provide a range *");
        System.out.println("*    (including a lower limit and a upper limit).   *");
        System.out.println("*    The user will have to guess a number which     *");
        System.out.println("*    will be in that given limit.                   *");
        System.out.println("*    Also the range lower limit value and the range *");
        System.out.println("*    upper limit value must have a gap of at least  *");
        System.out.println("*    10 digits (example: 0-11, 10-21).              *");
        System.out.println(GameHelper.DIVIDER_DECORATIVE_LINE);
        System.out.println("* 3. Then the user will be given a number of        *");
        System.out.println("*    chances to guess the number, where the number  *");
        System.out.println("*    of chances will be calculated based on the     *");
        System.out.println("*    level of the difficulty.");
        System.out.println(InputHelper.END_DECORATIVE_STRING);
    }

    /**
     * method to set how many chances has to be given to an user to guess the number
     * based on the level
     */
    private static void setNumberOfChances() {
        // check for the level of the game and set the number of chances
        switch (GameHelper.gameLevel) {
        case 1:
            GameHelper.numberOfChances = 7;
            break;
        case 2:
            GameHelper.numberOfChances = 5;
            break;
        case 3:
            GameHelper.numberOfChances = 3;
            break;
        default:
            break;
        }
    }

    private static void playGame() {
        boolean guessedCorrectly = false;

        while (GameHelper.numberOfChances > 0) {
            System.out.println("*********************** PLAY ************************");
            System.out.println(
                    "* CHANCES REMAINING --> " + (GameHelper.numberOfChances--) + "                           *");

            // get number guessed by user
            int guessedNumber = InputHelper.getUserInputForGuessedNumber();

            if (guessedNumber > GameHelper.randomNumber) {
                System.out.println("* YOU HAVE TO GUESS A LOWER VALUED NUMBER!          *");
            }
            else if (guessedNumber < GameHelper.randomNumber) {
                System.out.println("* YOU HAVE TO GUESS A HIGHER VALUED NUMBER!         *");
            }
            else {
                guessedCorrectly = true;
                System.out.println("* CONGRATULATIONS! YOU'VE GUESSED IT CORRECT!!!     *");
                System.out.println(InputHelper.END_DECORATIVE_STRING);
                break;
            }
        }

        if (!guessedCorrectly) {
            System.out
                    .println("* THE CORRECT NUMBER WAS --> " + GameHelper.randomNumber + "                         *");
            System.out.println(InputHelper.END_DECORATIVE_STRING);
        }
    }

    public static void startGame() {
        int upperRangeLimit;
        int lowerRangeLimit;
        // show introduction
        GameHelper.showIntroduction();

        // take user input for level of the game
        GameHelper.gameLevel = InputHelper.getUserInputForGameLevel();

        // take user input for lower limit
        lowerRangeLimit = InputHelper.getUserInputForLowerRangeLimit();

        // take user input for upper limit
        upperRangeLimit = InputHelper.getUserInputForUpperRangeLimit(lowerRangeLimit);

        // set number of chances according to the level
        GameHelper.setNumberOfChances();

        // set a random number within the range specified by user
        GameHelper.randomNumber = (int) (Math.random() * (upperRangeLimit - lowerRangeLimit)) + lowerRangeLimit;

        // play game
        GameHelper.playGame();
    }
}
