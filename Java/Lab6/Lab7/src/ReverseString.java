/**
 * Name: Ian Doarn
 * TA: Rojina Maharjan
 * Instructor: Bob Bagget
 * Date: 4/13/2017
 */
import java.util.*;
public class ReverseString
{
    public static void main(String[] chipsNDip)
    {
        Scanner inputter = new Scanner(System.in);
        System.out.print("Type something here:");
        String whatTheyTyped = inputter.next();
        reverseDisplay(whatTheyTyped);

    }

    public static void reverseDisplay(String string)
    {
        if (string.length() == 0)
        {
            // Didnt enter nothing, dont get nothing
            return;
        }

        // print last char as a substring at the last index of the string
        System.out.print(string.substring(string.length() - 1));

        // pass string in again, removing the last character,
        // using the substring method
        reverseDisplay(string.substring(0, string.length()-1));
    }
}
