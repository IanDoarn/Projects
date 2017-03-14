import java.util.ArrayList;

/**
 * Created by doarni on 3/14/2017.
 */
public class ProjectUtils
{
    public static int[] makeIntegerArray(String userInput)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        char[] charArray;
        charArray = userInput.toCharArray();

        for(int i = 0; i < charArray.length; i++)
        {
            int n = Character.getNumericValue(charArray[i]);
            arr.add(i, n);
        }

        int[] intArray = new int[arr.size()];

        for(int i = 0; i < intArray.length; i++)
        {
            intArray[i] = arr.get(i);
        }

        return intArray;
    }

    public static String makeStringArray(int[] intArray)
    {
        String string = "";
        for(int i = 0; i < intArray.length; i++)
        {
            string += " " + Integer.toString(intArray[i]);
        }
        return string;
    }
}
