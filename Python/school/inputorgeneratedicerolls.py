from quicksort import QuickSort
import sys
import random

RANGE = 6

class InputOrGenerateDiceRolls:

    def __init__(self):
        self.qs = QuickSort()


    def sort_array(self, array):
        return self.qs.quick_sort(array)

    @staticmethod
    def format_array(array):
        if ',' in str(array):
            return (str(array).replace(',', '')).strip('[]')
        else:
            return str(array).strip('[]')


    def make_array(self, user_input):
        try:
            return [int(x) for x in user_input.split(' ')]
        except:
            print('Input incorrect. "{}"'.format(user_input))
            return self.make_array(input('Please enter the five dice rolls:'))

    @staticmethod
    def make_random_roll():
        return [random.randrange(RANGE) for x in range(1, RANGE)]

def main():
    dr = InputOrGenerateDiceRolls()

    selection = input('Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit:')

    if selection == '3':
        print('Have a nice day!')
        sys.exit()

    elif selection == '1':
        _input = input('Please enter the five dice rolls:')
        print('The five rolls in non-decreasing order are: {}'.format(dr.format_array(dr.sort_array(dr.make_array(_input)))))

    elif selection == '2':
        print('The five rolls in non-decreasing order are: {}'.format(dr.format_array(dr.sort_array(dr.make_random_roll()))))


if __name__ == '__main__':
    main()
