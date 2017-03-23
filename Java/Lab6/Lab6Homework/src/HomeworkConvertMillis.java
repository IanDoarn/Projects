/**
 * Created by doarni on 3/21/2017.
 */
import java.util.Scanner;
public class HomeworkConvertMillis
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.print("Enter a value in milliseconds to convert:");
        long milli = in.nextLong();
        System.out.println(convertMillis(milli));
    }

    public static String convertMillis(long millis)
    {
        // Set x to milliseconds divided by 1000
        // converting it to whole seconds

        int x = (int)millis / 1000;

        // Round to the nearest second
        int seconds = x % 60;

        // divide by 60 to get minutes
        x /= 60;

        // Round to the nearest minute
        int minutes = x % 60;

        // divide by 60 to get hours
        x /= 60;

        int hours = x;

        // return result in HHH:MM:SS
        return hours + ":" + minutes + ":" + seconds;
    }
}
