/**
 * Write a class called OneRoundOneRollYahtzee.

 The program should behave the same as the InputOrGenerateDiceRolls
 program with the following additional feature.  After each set of
 five dice rolls has been displayed in non-decreasing order, the set
 of five dice rolls will be scored according to the rules of the
 dice game Yahtzee.   Before the score for the roll can be determined,
 the user must be prompted for a category to be used for scoring the
 dice roll.  The categories are listed on the next two pages which
 come from: https://en.wikipedia.org/wiki/Yahtzee
 Note that the first six categories (collectively called the “upper
 section”) and category 13 (called “Chance”) can be chosen for any
 set of five dice rolls.  However, categories 7-12 are only legal
 for certain dice rolls.  If the user chooses a legal category for
 the dice roll, your program should compute the score as specified
 in the Scores column of the tables.  However, if the user chooses
 an illegal category for the dice roll, your program should notify
 the user that his/her choice is illegal and allow him/her to select
 again.
 Note that we are not simulating the full game of Yahtzee.  We are
 only simulating one round of the game and the five dice are only
 being rolled once during this round.  If the user chooses to play
 again he/she will be starting a new one-round game with all of the
 scoring categories available in the sense that they are un-used.

 !!!!Helper Methods are located in the class ProjectUtils!!!!

 */

import java.util.*;

public class OneRoundOneRollYahtzee
{
    // Create the Scanner
    private static Scanner in = new Scanner(System.in);

    // Create an integer array
    public static int[] globalArray;

    // print helper methods because I got
    // lazy and didn't want to type
    // System.out.print(); anymore
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
        println("Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit:");
        int input = in.nextInt();

        // If the user enters 3, close the program
        if(input == 3)
        {
            ProjectUtils.exit();
        }
        // If 2, generate random array
        else if (input == 2)
        {
            int[] array = ProjectUtils.sortArray(ProjectUtils.generateIntArray(5, 1, 6));
            globalArray = array;
        }
        // If 1, get user to type value for array
        else if (input == 1)
        {
            //NOTE: apparently you have to do this before you can accept an input again. Stupid.
            in.nextLine();

            println("Please enter the five dice rolls:");
            String inputArray = in.nextLine();
            int[] array = ProjectUtils.sortArray(ProjectUtils.makeIntegerArray(inputArray));
            globalArray = array;
        }

        // Print the array
        println("The five rolls in non-decreasing order are: " + ProjectUtils.makeStringArray(globalArray));

        // Print selection menu
        selectionMenu();

        // User logic to determine score and print result
        println(yahtzeeLogic(getSelection(), globalArray));

    }
    private static void selectionMenu()
    {
        /*
            Prints selection menu
         */

        String menu = "Upper Section:\n" +
                "1. Aces\n" +
                "2. Twos\n" +
                "3. Threes\n" +
                "4. Fours\n" +
                "5. Fives\n" +
                "6. Sixes\n" +
                "Lower Section:\n" +
                "7. Three Of A Kind\n" +
                "8. Four Of A Kind\n" +
                "9. Full House\n" +
                "10. Small Straight\n" +
                "11. Large Straight\n" +
                "12. Yahtzee\n" +
                "13. Chance\n";

        println(menu);
    }

    private static int getSelection()
    {
        /*
            method for getting users selection
            so it be called recursively if the selection
            was not legal.
         */


        print("Please enter the number corresponding to your chosen category: ");
        return in.nextInt();
    }
    private static String yahtzeeLogic(int __selection, int[] array)
    {
        /*
            Determines which method of yahtzee logic
            to use and if it is a legal choice.

            displays the result of the choice
         */

        Logic yahtzee = new Logic();
        return yahtzee.main(__selection, array);
    }



    private static class Logic
    {
        /**
         * This class is the
         * Yahtzee logic for
         * determining the
         * various win types.
         *
         */

        String main(int selection, int[] array)
        {
            int[] upperSelection = new int[] { 1, 2, 3, 4, 5, 6 };
            int[] lowerSelection = new int[] { 7, 8, 9, 10, 11, 12, 13 };

            // Determine if selection is in upper set
            for(int x:upperSelection)
            {
                if (x == selection)
                {
                    // return score
                    return upperSection(selection, array);
                }
            }

            // Determine if selection is in lower set
            for(int x:lowerSelection)
            {
                if (x == selection)
                {
                    // return score
                    return lowerSection(selection, array);
                }
            }

            // If all else fails
            return null;
        }

        private String upperLogic(int[] array, int value, String categoryName)
        {
            /*
                Determines logic for Upper Section
             */

            // Make current array into a string
            String rollAsString = ProjectUtils.makeStringArray(array);

            if(ProjectUtils.checkElementInArray(value, array))
            {
                // make a map of the array
                HashMap<Integer, Integer> map = ProjectUtils.getElementCounts(array);

                // Formula: MostCommonElement * NumberOfTimesElementOccurs = Sum
                int sum = ProjectUtils.getMostCommonInt(array) * map.get(ProjectUtils.getMostCommonInt(array));

                return "Your score for the " + categoryName + " category is: " + sum;
            }

            //Selection was illegal for roll
            return "The " + categoryName + " category is not legal for this roll:" + rollAsString;

        }

        private String upperSection(int selection, int[] array)
        {
            /*
                Upper Section:
                1. Aces
                2. Twos
                3. Threes
                4. Fours
                5. Fives
                6. Sixes
             */

            switch(selection)
            {
                // Aces
                case 1:
                    return upperLogic(array, 1, "Aces");

                // Twos
                case 2:
                    return upperLogic(array, 2, "Twos");

                // Threes
                case 3:
                    return upperLogic(array, 3, "Threes");

                // Fours
                case 4:
                    return upperLogic(array, 4, "Fours");

                // Fives
                case 5:
                    return upperLogic(array, 5, "Fives");

                // Sixes
                case 6:
                    return upperLogic(array, 6, "Sixes");
            }

            // If all else fails
            // but hopefully not
            return null;
        }

        private String lowerSection(int selection, int[] array)
        {
            /*
                Lower Section:
                7. Three Of A Kind
                8. Four Of A Kind
                9. Full House
                10. Small Straight
                11. Large Straight
                12. Yahtzee
                13. Chance
             */

            switch(selection)
            {
                // Three Of A Kind
                case 7:
                    return numberOfAKind(array, 3, "Three Of A Kind");

                // Four Of A Kind
                case 8:
                    return numberOfAKind(array, 4, "Four Of A Kind");

                // Full House
                case 9:
                    return fullHouse(array);

                // Small Straight
                case 10:
                    break;

                // Large Straight
                case 11:
                    break;

                // Yahtzee
                case 12:
                    break;

                // Chance
                case 13:
                    break;
            }

            return null;
        }

        private String numberOfAKind(int[] intArray, int valueToFind, String categoryName)
        {
            /*
                Used for: Three Of A Kind and Four Of A Kind

                Find if there are a certain number
                of elements of the same value exist
                in the array
             */

            // Create a map of the array
            HashMap<Integer, Integer> map = ProjectUtils.getElementCounts(intArray);

            // Get the most common element in the array
            int mostCommonElement = ProjectUtils.getMostCommonInt(intArray);

            // If the most common element occurs the valueToFind times
            // Then we have valueToFind of a kind

            if(map.containsKey(mostCommonElement))
            {
                if(map.get(mostCommonElement) == valueToFind)
                {
                    return "Your score for the " + categoryName + " category is: " + ProjectUtils.sumArray(intArray);
                }
            }

            // There are not three values of the same number
            String rollAsString = ProjectUtils.makeStringArray(intArray);
            return "The " + categoryName + " category is not legal for this roll: " + rollAsString;
        }

        private String fullHouse(int[] intArray)
        {
            /*
                Full House

                Find if there are 2 numbers of the same value
                AND 3 numbers of the same value in the array
             */

            // Create the HashMap from the array
            HashMap<Integer, Integer> map = ProjectUtils.getElementCounts(intArray);

            int mostCommonElement = ProjectUtils.getMostCommonInt(intArray);

            for(int i = 0; i < intArray.length; i++)
            {
                // Find if the most common element occurs
                // 3 times
                if(map.containsKey(mostCommonElement))
                {
                    if(map.get(mostCommonElement) == 3)
                    {
                        map.remove(mostCommonElement);
                        int[] tempArray = ProjectUtils.removeFromArray(intArray, mostCommonElement);
                        mostCommonElement = ProjectUtils.getMostCommonInt(tempArray);

                        if(map.get(mostCommonElement) == 2)
                        {
                            return "Your score for the Full House category is: 25";
                        }
                    }
                }
            }

            // If we reach this point, there were not enough matches
            String rollAsString = ProjectUtils.makeStringArray(intArray);
            return "The Full House category is not legal for this roll: " + rollAsString;
        }
    }
}
