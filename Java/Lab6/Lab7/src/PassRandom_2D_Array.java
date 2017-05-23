/**
 * Created by doarni on 3/30/2017.
 */
import java.util.*;
import java.math.*;

public class PassRandom_2D_Array
{

    public static void main(String[] args) {
        int[][] m = getArray(); // Get an array
        print_2D_Array(m);
    }

    public static int[][] getArray() {
        int[][] m = new int[3][4];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = (int)(Math.random() * 9);

        return m;
    }

    public static void print_2D_Array(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int sum(int[][] m) {
        int total = 0;
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                total += m[row][column];
            }
        }

        return total;
    }
}
