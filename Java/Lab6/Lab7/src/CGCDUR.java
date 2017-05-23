/**
 * Name: Ian Doarn
 * TA: Rojina Maharjan
 * Instructor: Bob Bagget
 * Date: 4/13/2017
 */
import java.util.*;
public class CGCDUR
{
    public static void main(String[] potatoes)
    {
        Scanner inputter = new Scanner(System.in);
        System.out.print("Enter an integer m:");
        int _m = inputter.nextInt();
        System.out.print("Enter an integer n:");
        int _n = inputter.nextInt();

        System.out.print("The GCD is:" + gcd(_m, _n));
    }

    private static int gcd(int m, int n)
    {
        if(m % n == 0)
        {
            return n;
        }
        return gcd(m, m % n);
    }
}
