/**
 * Name: Ian Doarn
 * TA: Rojina Maharjan
 * Instructor: Bob Bagget
 * Date: 4/13/2017
 */
public class SumSeries
{
    public static void main(String[] fire)
    {
        System.out.print("m(10) = " + m(10));
    }

    private static double m(int i)
    {
        /*
            i
          ------
          2i + 1
         */

        // 0 cannot be an input, return 0 if it is
        if(i == 0)
        {
            return 0;
        }
        else
        {
            // Use formula for m(i)
            double sum = i/(2.0 * i + 1);

            // call m(int i) again, and add the
            // resulting value to the sum
            return sum + m(i-1);
        }
    }
}
