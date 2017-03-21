/**
 * Created by doarni on 3/21/2017.
 */
public class HomeworkConvertMillis
{
    public static void main(String[] args)
    {
        System.out.print(convertMillis(555550000));
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
