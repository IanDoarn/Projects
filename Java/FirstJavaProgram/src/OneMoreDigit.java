/**
 * Written By: Ian Doarn
 * Java Environment: 1.7 or 1.8
 */

import java.util.*;

public class OneMoreDigit
{
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

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
        print("Please enter zero or more digits in non-decreasing order (or q to quit):");
        String input = in.next();

        switch(input)
        {
            case "q":
                System.out.print("Have a nice a day!");
                System.exit(0);
                break;
            case "":
                int randInteger = randInt(1, 10);
                println("The following digit was randomly generated at great expense:" + randInteger);
                println("Here is the new sequence including the random digit:" + randInteger);
            default:
                run(input);
        }
    }

    private static int randInt(int min, int max)
    {
        int n = random.nextInt((max - min) + 1) + min;
        return n;
    }

    private static void run(String userInput)
    {
        int randInteger = randInt(1, 10);
        int[] temp = ProjectUtils.makeIntegerArray(userInput);
        int[] array = ProjectUtils.insertIntoArray(temp, randInteger);
        int[] sortedArray = ProjectUtils.sortArray(array);
        String stringedArray = ProjectUtils.makeStringArray(sortedArray);

        println("The following digit was randomly generated at great expense:" + randInteger);
        println("Here is the new sequence including the random digit:" + stringedArray);


    }
}
