/**
 * Write a class called GenerateDigits.

 The program should prompt the user to enter the number
 of digits to generate, or 0 to exit the program.
 The program should randomly generate the specified number
 of digits.  After each digit is randomly generated, the
 program should display the count of the digits generated
 and the new random digit.  Next, the program should
 construct a string consisting of the digits generated so
 far in non-decreasing order separated by spaces, and then
 output the string.

 !!!!Helper Methods are located in the class ProjectUtils!!!!

 */

import java.util.Scanner;
public class GenerateDigits
{
    private static Scanner in = new Scanner(System.in);

    /**
     * I got sick of typing this shit
     * Really I did, I'm so used to this in python
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
        print("Please enter the number of digits to generate (or 0 to exit):");
        int inputInt = in.nextInt();

        // Main logic
        generator(inputInt);

    }

    private static void generator(int numOfIterations)
    {
        /*
            Generates random numbers for a give number
            of times.
         */
        if(numOfIterations == 0)
        {
            print("Have a nice day!");
        }
        else
        {
            // Initial int to create the array with
            int initInt = ProjectUtils.generateRandomInteger(1, 100);
            int[] initArray = new int[] { initInt };

            println("Count: 1. Random integer: " + initInt + ". Digits so far in non-decreasing order: " + initInt);

            // Iterate a number of times, adding the random ints
            // to the array and print the new sorted array
            // each time
            for(int i = 2; i < numOfIterations + 1; i++)
            {
                // Make a random int
                int randInt = ProjectUtils.generateRandomInteger(1, 100);

                // Add it to the array
                initArray = ProjectUtils.insertIntoArray(initArray, randInt);

                // Sort it, make it a string and print
                String sortedArray = ProjectUtils.makeStringArray(ProjectUtils.sortArray(initArray));
                println("Count: " + i + ". Random integer: " + randInt + ". Digits so far in non-decreasing order: " + sortedArray);
            }
        }

    }
}
