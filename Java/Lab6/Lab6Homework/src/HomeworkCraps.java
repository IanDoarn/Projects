/**
 * Created by doarni on 3/21/2017.
 */
import java.util.*;

public class HomeworkCraps
{
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    private static void print(String text) { System.out.println(text); }

    private static int rollingSum = 0;
    private static boolean firstRound = true;

    public static void main(String[] args)
    {
        game();
    }

    private static void game()
    {
        int[] roll = makeRoll();
        int sum = sumRoll(roll);

        rollingSum = rollingSum + sum;

        print("You rolled " + roll[0] + " + " + roll[1] + " = " + sum);

        if(sum == 2 || sum == 3 || sum == 12)
        {
            print("You lose.");
            System.exit(0);
        }

        else if(firstRound && (sum == 7 || sum == 11))
        {
            print("You win!");
            System.exit(0);
        }

        else if(!firstRound && sum == 7)
        {
            print("You lose.");
            System.exit(0);
        }

        else if(sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10)
        {
            print("Your point is " + sum);
            firstRound = false;
            game();
        }

        else if(!firstRound && sum == rollingSum)
        {
            print("You win!");
            System.exit(0);
        }

        else
        {
            System.exit(0);
        }

    }
    private static int[] makeRoll()
    {
        int[] roll = new int[] {random.nextInt((6 - 1) + 1) + 1,
                random.nextInt((6 - 1) + 1) + 1 };
        return roll;
    }
    private static int sumRoll(int[] rollNumbers)
    {
        int sum = 0;

        for(int x = 0; x < rollNumbers.length; x++)
        {
            sum = sum + rollNumbers[x];
        }

        return sum;
    }
}
