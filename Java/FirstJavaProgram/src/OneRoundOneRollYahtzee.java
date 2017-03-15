/**
 * Write a class called OneRoundOneRollYahtzee.

 The program should behave the same as the InputOrGenerateDiceRolls
 program with the following additional feature.  After each set of
 five dice rolls has been displayed in non-decreasing order, the set
 of five dice rolls will be scored according to the rules of the
 dice game Yahtzee.   Before the score for the roll can be determined,
 the user must be prompted for a category to be used for scoring the
 dice roll.  The categories are listed on the next two pages which
 come from: https://en.wikipedia.org/wiki/Yahtzee
 Note that the first six categories (collectively called the “upper
 section”) and category 13 (called “Chance”) can be chosen for any
 set of five dice rolls.  However, categories 7-12 are only legal
 for certain dice rolls.  If the user chooses a legal category for
 the dice roll, your program should compute the score as specified
 in the Scores column of the tables.  However, if the user chooses
 an illegal category for the dice roll, your program should notify
 the user that his/her choice is illegal and allow him/her to select
 again.
 Note that we are not simulating the full game of Yahtzee.  We are
 only simulating one round of the game and the five dice are only
 being rolled once during this round.  If the user chooses to play
 again he/she will be starting a new one-round game with all of the
 scoring categories available in the sense that they are un-used.

 */
import java.util.Scanner;

public class OneRoundOneRollYahtzee
{
    // Create the Scanner
    private static Scanner in = new Scanner();

    // Alias my ProjectUtils class
    private static ProjectUtils utilities = new ProjectUtils();

    // print helper methods because I got lazy and didn't want to type
    // System.out.print(); anymore
    private static void print(String text)
    {
        System.out.print(text);
    }
    private static void println(String text)
    {
        System.out.println(text);
    }

    public static void main(String[] args)
    {
        println("'Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit:'");
    }

    void exit()
    {

        System.exit(0);
    }
}
