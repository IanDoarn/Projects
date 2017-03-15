/**
 * Written by: Ian Doarn
 *
 * These are my helper methods that are used in
 * the project. I have them in their own class
 * So I can globally call them in the project.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


public class ProjectUtils
{
    private static Random random = new Random();
    
    public static int generateRandomInteger(int min, int max)
    {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int[] makeIntegerArray(String userInput)
    {
        String[] stringArray = userInput.split(" ");
        int[] intArray = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++)
        {
            try
            {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            catch (NumberFormatException nfe)
            {
                //NOTE: Ignore this error
            }
        }

        return intArray;
    }

    public static String makeStringArray(int[] intArray)
    {
        StringBuilder builder = new StringBuilder();
        for (int i : intArray) {
            builder.append(i);
            builder.append(' ');
        }
        String text = builder.toString();
        return text;
    }

    public static int[] insertIntoArray(int[] inputArray, int newInt)
    {
        List<Integer> num = new ArrayList<>();

        for(int i = 0; i < inputArray.length; i++)
        {
            num.add(inputArray[i]);
        }
        num.add(newInt);

        int[] intArray = new int[num.size()];

        for(int i = 0; i < num.size(); i++)
        {
            intArray[i] = num.get(i);
        }

        return intArray;
    }

    public static int[] sortArray(int[] array)
    {
        QuickSort qs = new QuickSort();
        return qs.sort(array);
    }

    public static int[] generateIntArray(int size, int min, int max)
    {
        int[] generatedArray = new int[size];

        for(int i = 0; i < size; i++)
        {
            generatedArray[i] = generateRandomInteger(min, max);
        }

        return generatedArray;
    }

    public static boolean checkArrayLength(int[] array, int legalSize)
    {
        /*
            Check if an integer array is of a certian
            length. returns a boolean.
         */
        if(array.length != legalSize)
        {
            return false;
        }
        else if (array.length == legalSize)
        {
            return true;
        }
        return false;
    }
    public static int getMostCommonInt(int[] array) {

        /*
            Time complexity is: O(n log n)

            Finds the most common element in
            and integer array and returns it.
            If the array is null or empty, then
            0 is returned to indicate it is an
            empty array.
         */

        // Determine if the array is empty or null
        if (array == null || array.length == 0)
        {
            // since we are doing dice rolls, it is ok to return 0,
            // since 0 will never be in the arrays.
            return 0;
        }


        // Sort the array using our quick sort algorithm
        // since we can use the built-in: Arrays.sort(array)
        array = sortArray(array);

        int previous = array[0];
        int popular = array[0];
        int count = 1;
        int maxCount = 1;

        //iterate the array
        for (int i = 1; i < array.length; i++)
        {
            //if the previous element occurs again, increment its popularity by one.
            if (array[i] == previous)
            {
                count++;
            }
            else
            {

                if (count > maxCount)
                {
                    popular = array[i-1];
                    maxCount = count;
                }
                previous = array[i];
                count = 1;
            }
        }

        // if the current count is greater than the maxCount,
        // return the array index of that count, otherwise,
        // return the popular int
        return count > maxCount ? array[array.length-1] : popular;

    }
}

