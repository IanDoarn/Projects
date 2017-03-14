import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * Written By: Ian Doarn
 * Java Environment: 1.7 or 1.8
 */

import java.util.*;
import java.

public class OneMoreDigit
{
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    public static void main(String[] args)
    {
        System.out.print("Please enter zero or more digits in non-decreasing order (or q to quit):");
        String input = in.next();

        switch(input)
        {
            case "q":
                System.out.print("Have a nice a day!");
                System.exit(0);
                break;

            default:
                System.out.print("");

        }
    }

    private static int randInt(int min, int max)
    {
        int n = random.nextInt((max - min) + 1) + min;;
        return n;
    }
    private static String mainLogic(String userInput)
    {
        int[] sortedArray = sortArray(ProjectUtils.makeIntegerArray(userInput));
        int randInteger = randInt(1, 10);

        int[] newArray = new int[sortedArray.length + 1];


        String stringedArray = ProjectUtils.makeStringArray();

    }

    private static int[] sortArray(int[] array)
    {
        QuickSort qs = new QuickSort();
        return qs.sort(array);
    }
}
