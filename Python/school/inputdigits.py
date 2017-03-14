from quicksort import QuickSort
import sys

class InputDigits:

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

def main():
    id = InputDigits()

    _input = input('Please enter zero or more digits (or q to quit):')

    if _input == '':
        print('Here are the digits in non-decreasing order: ')

    elif _input.lower() == 'q':
        print('Have a nice day!')
        sys.exit()

    else:
        array = [int(x) for x in _input.split(' ')]
        print('Here are the digits in non-decreasing order: {}'.format(id.format_array(id.sort_array(array))))

if __name__ == '__main__':
    main()
