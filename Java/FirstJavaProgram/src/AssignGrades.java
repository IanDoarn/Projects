import java.util.*;

public class AssignGrades
{
    static int bestScoreNumber = 0;
    public static void main(String[] grapes)
    {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scan.nextInt();
        System.out.print("Enter " + numberOfStudents + " scores: ");
        String number = scan2.nextLine();
        String[] listOfScoresString = number.split(" ");

        int[] listOfScores = new int[listOfScoresString.length];
        for (int i = 0; i < listOfScoresString.length; i++)
        {
            listOfScores[i] = Integer.parseInt(listOfScoresString[i]);
        }
        bestScoreNumber = BestScore(listOfScores);
        for (int i = 0; i < listOfScores.length; i++)
        {
            System.out.println("Student  " + i + "  score is " + listOfScores[i] + " and grade is " + GetGrade(listOfScores[i]) + "\n");
        }
    }

    public static String GetGrade(int score)
    {
        if (score >= (bestScoreNumber - 10))
        {
            return "A";
        }

        else if (score >= (bestScoreNumber - 20))
        {
            return "B";
        }

        else if (score >= (bestScoreNumber - 30))
        {
            return "C";
        }

        else if (score >= (bestScoreNumber - 40))
        {
            return "D";
        }

        else
        {
            return "F";
        }
    }

    public static int BestScore(int[] scores)
    {
        int hi = scores[0];

        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] > hi)
                hi = scores[i];
        }

        return hi;
    }

}