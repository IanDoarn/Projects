/**
 * Name: Ian Doarn
 * Instructor: Bob Bagget
 * TA: Rojina Maharjan
 * Date: 4/20/2017
 */
import java.util.Scanner;
public class SumDigits
{
    private static Scanner input = new Scanner(System.in);

    private static void print(String text)
    {
        System.out.print(text);
    }

    private static void println(String text)
    {
        System.out.println(text);
    }

    public static void main(String[] fishies)
    {
        print("Enter an integer:");
        long n = input.nextLong();
        println("The sum of digits in " + n + " = " + sumDigits(n));
    }

    public static int sumDigits(long n)
    {
        return sumDigits(n, 0);
    }

    private static int sumDigits(long n, int sum)
    {
        if (n == 0)
        {
            return sum;
        }
        else
        {
            return sumDigits(n / 10, sum + (int) (n % 10));
        }
    }
}

