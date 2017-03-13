from quicksort import QuickSort
import random
import sys


RANGE = 10

class OneMoreDigit:

    def __init__(self):
        self.qs = QuickSort()
        self.sorted_list = []

    def sort_array(self, array):
        self.sorted_list = self.qs.quick_sort(array)
        return self.sorted_list

def main():
    omd = OneMoreDigit()
    _input = input('Please enter zero or more digits in non-decreasing order (or q to quit):')

    if _input.lower() == 'q':
        print('Have a nice day!')
        sys.exit()

    else:
        rand_int = random.randrange(RANGE)
        if len(_input) == 0:
            array = [rand_int]
            print('The following digit was randomly generated at great expense: ' + str(rand_int))
            print('Here is the new sequence including the random digit: ' + (str(array)).strip('[]'))
        else:
            array = [int(x) for x in _input.split(' ')]

            print('The following digit was randomly generated at great expense: ' + str(rand_int))
            array.append(rand_int)
            new_array = omd.sort_array(array)
            print('Here is the new sequence including the random digit: ' + (str(new_array).replace(',', '')).strip('[]'))


if __name__ == '__main__':
    main()
