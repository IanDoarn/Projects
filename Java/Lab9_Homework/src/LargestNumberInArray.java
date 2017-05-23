/**
 * Name: Ian Doarn
 * Instructor: Bob Bagget
 * TA: Rojina Maharjan
 * Date: 4/20/2017
 */
import java.util.Scanner;

public class LargestNumberInArray
{
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] drums)
    {

        System.out.print("Enter eight integers separated by spaces: ");
        int[] list = new int[8];

        for (int i = 0; i < list.length; i++)
        {
            list[i] = input.nextInt();
        }

        System.out.println("The largest element is " + max(list));
    }

    public static int max(int[] intList)
    {
        int m = intList[intList.length - 1];
        int i = intList.length - 1;
        return max(intList, i, m);
    }

    private static int max(int[] intList, int i, int mx)
    {
        if (i < 0)
        {
            return mx;
        }
        else if (intList[i] > mx)
        {
            return max(intList, i - 1, intList[i]); // Recursive call
        }
        else
            {
            return max(intList, i - 1, mx); // Recursive call
        }
    }
}

