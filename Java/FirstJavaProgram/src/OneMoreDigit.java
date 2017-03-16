/**
 * Write a class called OneMoreDigit.

 The program should prompt the user to enter a string consisting of zero or more
 digits in non-decreasing order separated by spaces – be sure to read this in as
 a single string.  Non-decreasing order means “sorted” with duplicates allowed.
 For example, the user might enter the string “2 2 5 8” (of course the user does
 not type the quotes).  Or the user might enter the empty string (by simply pressing
 the “enter” key at the prompt) since he/she was prompted to enter “zero or more
 digits in non-decreasing order.”  Also, the user can enter the letter q by itself
 to quit the program.
 Next, your program should generate a random digit and inform the user what digit
 was generated.  For example, if the random digit was a 5 then program might display
 “The following digit was randomly generated at great expense: 5”.
 Next, the program should construct a string identical to the string that the user
 entered but with the randomly-generated digit inserted into a correct position so
 that the resulting string is still in non-decreasing order.  For example, if the
 user entered “2 2 5 8” and the randomly-generated digit was 5, then the new string
 should be “2 2 5 5 8”.  Of course if the user entered the empty string and the
 randomly-generated digit was 7, then the new string would just be “7”.
 The program should output the new string.


 !!!!Helper Methods are located in the class ProjectUtils!!!!


 */

import java.util.*;

public class OneMoreDigit
{
    private static Scanner in = new Scanner(System.in);

    /**
     * I got sick of typing this shit
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
        println("Please enter zero or more digits in non-decreasing order (or q to quit):");
        String input = in.nextLine();

        // They choose to exit
        if(input.contains("q"))
        {
            ProjectUtils.exit();
        }

        // Generate a random int
        int randInt = ProjectUtils.generateRandomInteger(1, 10);

        // If they typed some stuff
        if(input.length() > 0)
        {
            // Create an array from the give string
            int[] array = ProjectUtils.insertIntoArray(ProjectUtils.makeIntegerArray(input), randInt);

            // Sort that shit
            int[] sortedArray = ProjectUtils.sortArray(array);
            String sortedArrayAsString = ProjectUtils.makeStringArray(sortedArray);

            // Print that shit
            println("The following digit was randomly generated at great expense: " + randInt);
            println("Here is the new sequence including the random digit: " + sortedArrayAsString);
        }
        else
        {
            // They didn't type anything
            // So just print the random int that was generated
            println("The following digit was randomly generated at great expense: " + randInt);
            println("Here is the new sequence including the random digit: " + randInt);
        }


    }
}
