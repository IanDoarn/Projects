"""
Quick Sort Algorithm
Performance depends largely on Pivot selection.
Worst case: O(n^2)
Best case: O(n log n)

Written by: Ian Doarn

References:

https://www.youtube.com/watch?v=CB_NCoxzQnk
https://github.com/joeyajames/Python/blob/master/SortingAlgorithms.py

"""
import time
import random


THRESHOLD = 20
SIZE = 10000
SPAN = 1000000


class QuickSort:

    def __init__(self):
        self.FUNC_QUICK_SELECTION = 0
        self.PARTITIONS = 0
        self.SORTS = 0

    def quick_sort(self, array):
        """
        Takes a list of values and passes
        it into the recursive function sort()

        Sort takes the inputs of:

            array - the list of values
            low - the low index of the list: 0
            hi - the hi index of the list: len(array) - 1

        :param array: List of values
        :return: sorted array
        """
        return self.sort(array, 0, len(array)-1)

    def sort(self, array, low, hi):
        """
        Recessive function

        :param array: List of numbers to srot
        :param low: Low index
        :param hi: Hi index
        :return:
        """

        self.SORTS += 1
        sorted_array = []

        if hi - low < THRESHOLD and low < hi:
            sorted_array = self.quick_selection(array, low, hi)

        elif low < hi: # if there is more than one item in the list
            # Partition does most of the work of the quick sort
            # It returns the pivot around which we partition the list
            p = self.partition(array, low, hi)
            sorted_array = p
            # recursively called for items to the left of the pivot
            sorted_array = self.sort(array, low, p - 1)

            # recursively called for items to the right of the pivot
            sorted_array = self.sort(array, p + 1, hi)

        return sorted_array

    def pivot(self, array, low, hi):
        """
        This is one of the key parts of the quick sort
        We calculate a mid index using the low index
        and the high and then through a series of
        comparisons between: low, mid, hi
        we choose the middle of the three.
        This will benefit us greatly when we use the partition
        function

        :param array: List of values
        :param low: Low index
        :param hi: High index
        :return: pivot
        """

        mid = (hi + low) // 2

        sorted_list = sorted([array[low], array[mid], array[hi]])

        if sorted_list[1] == array[low]:
            return low
        elif sorted_list[1] == array[mid]:
            return mid
        return hi


    def partition(self, array, low, hi):

        """
        This is the actual swapping procedure of quick sort

        First, we get the pivot index and set it as the border value
        Next, we iterate our list from low to high, if our the item is
        less than out pivot, we swap the item with the border. This way
        all items below the pivot value are swapped to the left side of the list
        with the border being the control point. Each time we iterate, we increment the border
        value by 1 moving it to the right one space.
        Finally, we swap the low value into the border position and return the
        border as the index for out pivot.


        :param array:
        :param low:
        :param hi:
        :return:
        """

        self.PARTITIONS += 1

        pivot_index = self.pivot(array, low, hi)
        pivot_value = array[pivot_index]

        # I love swapping in python
        array[pivot_index], array[low] = array[low], array[pivot_index]

        border = low

        for index in range(low, hi + 1):
            if array[index] < pivot_value:
                border += 1
                array[index], array[border] = array[border], array[index]
            array[low], array[border] = array[border], array[low]

        return border


    def quick_selection(self, x, first, last):
        """
        This is a simple implementation of selection sorting

        :param x:
        :param first:
        :param last:
        :return:
        """
        # print(x)

        self.FUNC_QUICK_SELECTION += 1

        for i in range(first, last):
            minIndex = i
            for j in range(i + 1, last + 1):
                if x[j] < x[minIndex]:
                    minIndex = j
            if minIndex != i:
                x[i], x[minIndex] = x[minIndex], x[i]
        return x

#================================
# Now we test to see if it works!
#================================

# Example usage if used from the command line, otherwise, can be imported as a module

if __name__ == '__main__':
    import sys

    if len(sys.argv[1:]) < 1:

        print('using default size: [{}]'.format(str(SIZE)))
        us = [random.randint(0,SPAN) for a in range(0, SIZE)]
        qs = QuickSort()

        start_time = time.time()
        qs.quick_sort(us)
        print('SIZE: {} Elapsed time: {} seconds'.format(str(SIZE), str(time.time() - start_time)))
        print('Selections: [{}] Sorts: [{}] Partitions: [{}]'.format(str(qs.FUNC_QUICK_SELECTION),
                                                                     str(qs.SORTS),
                                                                     str(qs.PARTITIONS)))
    else:

        SIZE = int(sys.argv[1])

        us = [random.randint(0, SPAN) for a in range(0, SIZE)]
        qs = QuickSort()

        start_time = time.time()
        qs.quick_sort(us)

        print('SIZE: [{}] Elapsed time: [{}] seconds'.format(str(SIZE), str(time.time() - start_time)))
        print('Selections: [{}] Sorts: [{}] Partitions: [{}]'.format(str(qs.FUNC_QUICK_SELECTION),
                                                                     str(qs.SORTS),
                                                                     str(qs.PARTITIONS)))


