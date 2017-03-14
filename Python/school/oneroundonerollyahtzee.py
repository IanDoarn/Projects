from quicksort import QuickSort
import random
import sys

ROLL_RANGE = 5
DICE_RANGE = 6

SELECTION_PROMPT = """You may select from the following scoring categories:
Upper Section:
1. Aces
2. Twos
3. Threes
4. Fours
5. Fives
6. Sixes
Lower Section:
7. Three Of A Kind
8. Four Of A Kind
9. Full House
10. Small Straight
11. Large Straight
12. Yahtzee
13. Chance
"""

SELECTIONS = {}

class OneRoundOneRollYahtzee:

    def __init__(self):
        self.qs = QuickSort()
        self.upper_section = {'aces': {'dice_number': 1},
                              'twos': {'dice_number': 2},
                              'threes': {'dice_number': 3},
                              'fours': {'dice_number': 4},
                              'fives': {'dice_number': 5},
                              'sixes': {'dice_number': 6}
                              }

    @staticmethod
    def format_array(array):
        if ',' in str(array):
            return (str(array).replace(',', '')).strip('[]')
        else:
            return str(array).strip('[]')

    @staticmethod
    def make_random_roll():
        return [random.randrange(DICE_RANGE) for x in range(1, ROLL_RANGE)]

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
        most_common_number, data = self.get_most_common_element(array)
        for key, value in self.upper_section.items():
            if value['dice_number'] == int(most_common_number):
                return key, value, sum(array), data, most_common_number

    def read_lower_section(self, array, rule):

        most_common_element, data = self.get_most_common_element(self.sort_array(array))


        def three_of_a_kind(array):
            if data[most_common_element] == 3:
                return True, sum(array)

        def four_of_a_kind(array):
            if data[most_common_element] == 4:
                return True, sum(array)

        def full_house():
            _dict = data
            if _dict[most_common_element] == 3:
                _dict.pop(most_common_element, None)
                mce = max(_dict, key=dict.get)
                if _dict[mce] == 2:
                    return True, 25

        def small_straight(array):
            __array = self.sort_array(array)
            primary_set = []
            for i in __array:
                if i in primary_set:
                    pass
                else:
                    primary_set.append(i)
            if len(primary_set) == 4:
                return True, 30

        def large_straight(array):
            __array = self.sort_array(array)
            primary_set = []
            for i in __array:
                if i in primary_set:
                    pass
                else:
                    primary_set.append(i)
            if len(primary_set) == 5:
                return True, 40

        def yahtzee(array):
            for i in array:
                if i == array[0]:
                    pass
                else:
                    return False
            return True, 50

        def chance(array):
            if data[most_common_element] > 1:
                return True, sum(array)

        '''
        7. Three Of A Kind
        8. Four Of A Kind
        9. Full House
        10. Small Straight
        11. Large Straight
        12. Yahtzee
        13. Chance
        '''

        if rule == '7':
            return three_of_a_kind(array)
        elif rule == '8':
            return four_of_a_kind(array)
        elif rule == '9':
            return full_house()
        elif rule == '10':
            return small_straight(array)
        elif rule == '11':
            return large_straight(array)
        elif rule == '12':
            return yahtzee(array)
        elif rule == '13':
            return chance(array)
        else:
            print('That is not a rule! "{}"'.format(rule))


def main():
    yahtzee_rules = OneRoundOneRollYahtzee()

    _input = input('Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit:')

    if _input == '3':
        print('Have a nice day!')
        sys.exit()

    elif _input == '1':
        ask = input('Please enter the five dice rolls:')
        array = yahtzee_rules.make_array(ask)
        print('The five rolls in non-decreasing order are:' + yahtzee_rules.format_array(array))
        print(SELECTION_PROMPT)
        selection = input('Please enter the number corresponding to your chosen category:')

        if int(selection) in [1, 2, 3, 4, 5, 6]:
            key, value, arr_sum, data, mcn = yahtzee_rules.read_upper_section(array)
            print('Your score for the {} is :{}.'.format(key, data[mcn]))

        elif int(selection) in [7, 8, 9, 10, 11, 12, 13]:
            a, b = yahtzee_rules.read_lower_section(array, selection)
            print(a)
            print(b)

if __name__ == '__main__':
    main()
