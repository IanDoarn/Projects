import random
import sys

from misc.quicksort import QuickSort

RANGE = 100

class GenerateDigits:

    def __init__(self):
        self.qs = QuickSort()

    @staticmethod
    def format_array(array):
        if ',' in str(array):
            return (str(array).replace(',', '')).strip('[]')
        else:
            return str(array).strip('[]')

    @staticmethod
    def make_random_number():
        return random.randrange(RANGE)

    def sort_array(self, array):
        return self.qs.quick_sort(array)


def main():
    gd = GenerateDigits()
    array = []
    _input = input('Please enter the number of digits to generate (or 0 to exit):')

    if _input == '0':
        print('Have a nice day!')
        sys.exit()

    else:
        for i in range(0, int(_input)):
            rand_int = gd.make_random_number()
            array.append(rand_int)

            if i == 0:
                print('Count: {}. Random digit: {}.  Digits so far in non-decreasing order: {}.'.format(str(i + 1), str(rand_int), gd.format_array(array)))
            else:
                print('Count: {}. Random digit: {}.  Digits so far in non-decreasing order: {}.'.format(str(i + 1),
                                                                                                        str(rand_int),
                                                                                                        gd.format_array(gd.sort_array(array))))
if __name__ == '__main__':
    main()
