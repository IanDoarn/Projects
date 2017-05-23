/**
 * Name: Ian Doarn
 * Instructor: Bob Bagget
 * TA: Rojina Maharjan
 * Date: 4/20/2017
 */
import java.util.Scanner;

public class Base2ToBase10
{

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] cruiseShip)
    {

            // Prompt user
            System.out.print("Enter a binary string: ");

            // Get input
            String binaryString = input.next();

            // Call Method, print output
            System.out.println("The decimal equivalent of " + binaryString + " is " + bin2Dec(binaryString));
        }

        // Initial call to then call helper
        public static int bin2Dec(String b2String)
        {
            // Index
            int i = 0;

            // Number
            int n = b2String.length() - 1;

            //Result
            int r = 0;

            // Begin terribly inefficient recursive loop
            return b2Tob10(b2String, i, n, r);
        }


        // Recursive method. Converts Base2 to Base10
        public static int b2Tob10(String b2String, int i, int n, int r)
        {
            // I'm using Integer.parseInt because this conversion from
            // base2 to base10 is already horribly inefficient. No
            // point in making it worse.

            r += (Integer.parseInt(b2String.charAt(i) + "") * (int) Math.pow(2, n));

            if (n == 0)
            {
                return r;
            }
            else
            {
                // Recursive call to this method again
                return b2Tob10(b2String, i + 1, n - 1, r);
            }
        }
}
