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



//TODO: clean up some of this to make it faster

public class ProjectUtils
{
    // create Random object
    private static Random random = new Random();

    public static void main(String[] args)
    {
        //NOTE: This is a place holder in case I need to test something

    }

    public static void exit()
    {
        System.out.println("Have a nice day!");
        System.exit(0);
    }

    public static int generateRandomInteger(int min, int max)
    {
        /*
            Create a random number within the given range
            and return it
         */
        return random.nextInt((max - min) + 1) + min;
    }

    public static int[] makeIntegerArray(String userInput)
    {
        /*
            take given user input string and convert it to
            an integer array. This is assuming the users input is
            delimited by a space.

            Example:

                input: "1 2 3 4 5"
                output: [1, 2, 3, 4, 5]
         */
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
        /*
            Take a give array and transform it to a string
            with a char delimiter of ' '

            Example:

            given array: {1, 2, 3, 4, 5}
            output: "1 2 3 4 5"
         */
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
        /*
            Inserts an integer at the end of an array
         */
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
        /*
            use my quick sorting algorithm
            to sort an array of integers and
            return the sorted array
         */

        QuickSort qs = new QuickSort();
        return qs.sort(array);
    }

    public static int[] generateIntArray(int size, int min, int max)
    {
        /*
            Randomly generate an array of certain size
            with give integer range of min and max
         */
        int[] generatedArray = new int[size];

        for(int i = 0; i < size; i++)
        {
            generatedArray[i] = generateRandomInteger(min, max);
        }

        return generatedArray;
    }

    public static int sumArray(int[] intArray)
    {
        /*
            Sum all values in int array
         */
        int sum = 0;

        for(int i = 0; i < intArray.length; i++ )
        {
            sum += intArray[i];
        }

        return sum;
    }

    public static HashMap<Integer, Integer> getElementCounts(int[] intArray)
    {
        /*
            Builds a HashMap of each value in the array
            by assigning each value as the key, and the
            number of times it occurs in the array as
            the value

            since the array is iterated once, this
            is very efficient
         */

        // Create a HashMap object
        HashMap<Integer, Integer> intMap = new HashMap<>();

        // iterate the array
        for(int i = 0; i < intArray.length; i++)
        {
            // check if the current array value
            // is a key in the HashMap, if it is,
            // increase it's key value by one,
            // otherwise put it in the HashMap
            // and then assign it a value of one

            if(intMap.get(intArray[i]) != null)
            {
                intMap.put(intArray[i], intMap.get(intArray[i]) + 1);
            }
            else
            {
                intMap.put(intArray[i], 1);
            }
        }

        return intMap;
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

    public static boolean checkElementInArray(int element, int[] intArray)
    {
        /*
            Simply used to check if a number
            exists in an int array
            returns a boolean
         */

        for(int i = 0; i < intArray.length; i++)
        {
            // if the number we are looking for is in the array
            // return true
            if(i == element) { return true; }
        }

        // If the program reaches this point
        // the number wasn't found in the array
        return false;
    }


    public static int getElementCount(int[] array, int element)
    {
        /*
            Gets the number of times
            an element occurs in an array
         */

        int count = 0;

        // Determine if array is empty or null
        if(array == null || array.length == 0)
        {
            return 0;
        }
        else
        {
            // iterate array
            for (int i = 0; i < array.length; i++)
            {
                if (array[i] == element)
                {
                    count++;
                }
            }
            return count;
        }
    }
    public static int getMostCommonInt(int[] array)
    {

        /*
            Time complexity is: O(n log n)

            Finds the most common element in
            and integer array and returns it.
            If the array is null or empty, then
            0 is returned to indicate it is an
            empty array.

            the given array does not need to be sorted,
            it will automatically be sorted.

            References used:

            http://stackoverflow.com/questions/8545590/find-the-most-popular-element-in-int-array
            http://stackoverflow.com/questions/3903651/most-common-values-in-an-array

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

        // iterate the array
        for (int i = 1; i < array.length; i++)
        {
            // if the previous element occurs again, increment its popularity by one.
            if (array[i] == previous)
            {
                count++;
            }

            // otherwise continue to the next element
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
        // See I know how to use the ternary operator....
        return count > maxCount ? array[array.length-1] : popular;

    }
}

