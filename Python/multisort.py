"""
Using Quick Sort
on multi dimensional arrays

Yeah

Written by: Ian Doarn
"""

import quicksort
import random
import time

SIZE = 1000
SPAN = 1000000
DIMENSION = 100

TOTAL_FUNC_QUICK_SELECTION = 0
TOTAL_SORTS = 0
TOTAL_PARTITIONS = 0

ARRAY = []

qs = quicksort.QuickSort()

for _ in range(DIMENSION):
    ARRAY.append([random.randint(0,SPAN) for a in range(0, SIZE)])


start_time = time.time()
for i in range(len(ARRAY)):
    ARRAY[i] = qs.quick_sort(ARRAY[i])

    TOTAL_FUNC_QUICK_SELECTION += qs.FUNC_QUICK_SELECTION
    TOTAL_SORTS += qs.SORTS
    TOTAL_PARTITIONS += qs.PARTITIONS

print('Dimension: [{}] Sub-Array Size: [{}] Elapsed time: [{}] seconds'.format(str(DIMENSION),
                                                                                 str(SIZE),
                                                                                 str(time.time() - start_time)))
print('Selections: [{}] Sorts: [{}] Partitions: [{}]'.format(str(TOTAL_FUNC_QUICK_SELECTION),
                                                             str(TOTAL_SORTS),
                                                             str(TOTAL_PARTITIONS)))
