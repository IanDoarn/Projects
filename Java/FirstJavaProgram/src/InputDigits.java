/**
 * Write a class called InputDigits.

 The program should prompt the user to enter a string consisting
 of zero or more digits in any order with duplicates allowed and
 separated by spaces – be sure to read this in as a single string.
 The program should construct a string with the digits in
 non-decreasing order separated by spaces.
 Finally the program should output the constructed string.

 !!!!Helper Methods are located in the class ProjectUtils!!!!

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

        // If they typed q, exit
        if(input.contains("q"))
        {
            ProjectUtils.exit();
        }
        else
        {
            // create the array
            int[] array;

            // Create an empty string
            String arrayString = "";

            // As long as the input isn't 0
            if(input.length() > 0)
            {
                // Make the array an int array
                // sort it, then convert it to a string
                array = ProjectUtils.sortArray(ProjectUtils.makeIntegerArray(input));
                arrayString = ProjectUtils.makeStringArray(array);
            }

            // Print the array, or nothing it the input was nothing
            print("Here are the digits in non-decreasing order: " + arrayString);
        }
    }
}
