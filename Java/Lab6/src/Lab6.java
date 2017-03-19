/**
 * Author: Ian Doarn
 * Assignment: Lab6
 * Instructor: Bob Bagget
 * TA: Rojina Maharjan
 * Date: 3/16/2017
 */
import java.util.*;

public class Lab6 {
    public static void println(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {

    }

    //Returns true if number is a palindrome
    public static boolean isPalindrome(int number) {
        int n = reverse(number);
        if (reverse(number) == n) {
            return true;
        }
        return false;
    }

    //Return the reversal of an integer, i.e., reverse(456) returns 654
    public static int reverse(int number) {
        int n = 0;

        for (int i = number; i != 0; i /= 10) {
            n = n * 10 + i % 10;
        }
        return n;
    }

    public static void runPentagonal(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count != 10) {
                System.out.print(getPentagonalNumber(i) + "\t");
                count++;
            } else {
                println("\n");
                count = 0;
            }
        }
    }

    public static int getPentagonalNumber(int n) {
        /*
            formula:

                n(3n-1)
            p = -------
                   2
         */

        return n * (3 * n - 1) / 2;
    }

}

public static class SortedNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three numbers: ");
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        displaySortedNumbers(number1, number2, number3);
    }


    public static void displaySortedNumbers(double num1, double num2, double num3) {
        double temp;

        if (num2 < num1 && num2 < num3) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        } else if (num3 < num1 && num3 < num2) {
            temp = num1;
            num1 = num3;
            num3 = temp;
        }
        if (num3 < num2) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }


        System.out.println(num1 + " " + num2 + " " + num3);
    }

}