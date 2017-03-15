/**
 * Write a class called InputDigits.

 The program should prompt the user to enter a string consisting
 of zero or more digits in any order with duplicates allowed and
 separated by spaces – be sure to read this in as a single string.
 The program should construct a string with the digits in
 non-decreasing order separated by spaces.
 Finally the program should output the constructed string.
 */

import java.util.Scanner;

public class InputDigits
{
    private static Scanner in = new Scanner(System.in);

    /**
     * I got sick of typing this shit
     * Really I did, I'm so used to this in python
     * print(); is so much better than System.out.print(); right?
     */
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
        println("Please enter zero or more digits (or q to quit):");
        String input = in.nextLine();

        if(input.contains("q"))
        {
            println("Have a nice day!");
            System.exit(0);
        }
        else
        {
            int[] array;
            String arrayString = "";

            if(input.length() > 0)
            {
                array = ProjectUtils.sortArray(ProjectUtils.makeIntegerArray(input));
                arrayString = ProjectUtils.makeStringArray(array);
            }

            print("Here are the digits in non-decreasing order: " + arrayString);
        }
    }
}
