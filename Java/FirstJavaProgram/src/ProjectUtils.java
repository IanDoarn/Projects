import java.util.ArrayList;
import java.util.*;


public class ProjectUtils
{
    private static Random random = new Random();
    
    public static int generatRandomInteger(int min, int max)
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
            generatedArray[i] = generatRandomInteger(min, max);
        }

        return generatedArray;
    }

    public static boolean checkArrayLength(int[] array, int legalSize)
    {
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
}
