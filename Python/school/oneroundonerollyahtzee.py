from quicksort import QuickSort
import random
import sys


class YahtzeeRules:

    def __init__(self):
        self.qs = QuickSort()
        self.upper_section = {'aces': {'dice_number': 1},
                              'twos': {'dice_number': 2},
                              'threes': {'dice_number': 3},
                              'fours': {'dice_number': 4},
                              'fives': {'dice_number': 5},
                              'sixes': {'dice_number': 6}
                              }


    def sort_array(self, array):
        return self.qs.quick_sort(array)


    def make_array(self, user_input):
        try:
            return [int(x) for x in user_input.split(' ')]
        except:
            print('Input incorrect. "{}"'.format(user_input))


    def get_most_common_element(self, array):
        array = self.sort_array(array)
        dict = {}
        count = None
        for x in range(0, len(array)):
            count = 1
            if array[x] in dict:
                count = count + dict[array[x]]
            dict[array[x]] = count
        return max(dict, key=dict.get), dict


    def read_upper_section(self, array):
        most_common_number, _ = self.get_most_common_element(array)
        for key, value in self.upper_section.items():
            if key['dice_number'] == most_common_number:
                return key

    def read_lower_section(self, array, rule):

        most_common_element, data = self.get_most_common_element(self.sort_array(array))

        def three_of_a_kind():
            if data[most_common_element] == 3:
                return True

        def four_of_a_kind():
            if data[most_common_element] == 4:
                return True

        def full_house():
            _dict = data
            if _dict[most_common_element] == 3:
                _dict.pop(most_common_element, None)
                mce = max(_dict, key=dict.get)
                if _dict[mce] == 2:
                    return True

        def small_straight(array):
            __array = self.sort_array(array)
            primary_set = []
            for i in __array:
                if i in primary_set:
                    pass
                else:
                    primary_set.append(i)

            if len(primary_set) == 4:
                return True



# class OneRoundOneRollYahtzee:

