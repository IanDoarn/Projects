/**
 * Write a class called InputOrGenerateDiceRolls.

 The program should ask the user whether the user prefers 1)
 to roll his/her own dice, 2) use computer-generated dice rolls,
 or 3) quit the program.  If the user prefers to roll his/her own
 dice, the program should prompt the user to enter
 5 digits in the range from 1-6 separated by spaces in any order with
 duplicates allowed.  However, if the user prefers to
 use computer-generated dice rolls, generate 5 random digits in the range
 from 1-6 with duplicates allowed.
 Next, regardless of the user’s preference, display the 5 digits
 (representing 5 dice rolls) in non-decreasing order.

 *Here is an example run of the program.

 Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit: 1
 Please enter the five dice rolls: 4 2 6 1 1
 The five rolls in non-decreasing order are: 1 1 2 4 6

 Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit: 2
 The five rolls in non-decreasing order are: 2 4 4 5 5

 Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit: 3
 Have a nice day!

 */


import java.util.*;


public class InputOrGenerateDiceRolls
{
    private static Scanner in = new Scanner(System.in);

    private static void print(String text)
    {
        System.out.print(text);
    }

    private static void println(String text)
    {
        System.out.println(text);
    }

    public static void main(String[] args)
    {
        print("Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit:");
        int choice = in.nextInt();

        if(choice == 3)
        {
            println("Have a nice day!");
            System.exit(0);
        }
        else
        {
            int[] array;

            if(choice == 2)
            {
                array = ProjectUtils.sortArray(ProjectUtils.generateIntArray(5, 1, 6));
                println("The five rolls in non-decreasing order are: " + ProjectUtils.makeStringArray(array));
            }
            else {
                println("Please enter the five dice rolls:");
                int[] userArray = ProjectUtils.makeIntegerArray(in.nextLine());

                if (ProjectUtils.checkArrayLength(userArray, 5)) {
                    array = ProjectUtils.sortArray(userArray);
                    println("The five rolls in non-decreasing order are: " + ProjectUtils.makeStringArray(array));
                }
                else
                {
                    println("You did not enter enough or you entered too many rolls!");
                    System.exit(0);
                }
            }
        }
    }
}
