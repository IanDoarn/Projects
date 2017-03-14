/** Java Quick Sorting algorithm
 *
 *  Best case time space:
 *  O(nlogn)
 *
 *  Worst case time space
 *  O(n^2)
 *
 *  Wrttien by: Ian Doarn
 *
 *  References:
 *  http://www.java2novice.com/java-sorting-algorithms/quick-sort/
 *
 */

public class QuickSort {
    private int[] array;
    private int length;

    public int[] sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return null;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
        return this.array;
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        // Calculate the pivot number from the array, generally is the middle number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             * - See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.T4o1aqcU.dpuf
             */

            while (array[i] < pivot)
            {
                i++;
            }
            while (array[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
            // call quickSort() method recursively
            if (lowerIndex < j)
                quickSort(lowerIndex, j);
            if (i < higherIndex)
                quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j)
    {
        /*
            Swap numbers:
            [a, b] --> [b, a]
         */
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
