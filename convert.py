'''
Simple python base binary converter
Convert between binary bases of 2, 10, and 16
Also convert ASCII to base 2 and 16

Usable with command line or as an
importable module!

Created by: Ian Doarn
'''
import math


class Convert:
    def __init__(self, base=2, val_type=int):
        self.base = base
        self.val_type = val_type

        '''Sequence of decimal numbers'''
        self.decimals = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        '''List of Hex letters'''
        self.hex_letters = ['A', 'B', 'C', 'D', 'E', 'F']

        '''Dictionary of Hex letters and their respective base10 values'''
        self.hex_letter_values = {'A': 10, 'B': 11, 'C': 12,
                                  'D': 13, 'E': 14, 'F': 15}

        '''Dictionary of base2 values snd their respective base16 values'''
        self.hex_values = {"0000": "0", "0001": "1", "0010": "2",
                           "0011": "3", "0100": "4", "0101": "5",
                           "0110": "6", "0111": "7", "1000": "8",
                           "1001": "9", "1010": "A", "1011": "B",
                           "1100": "C", "1101": "D", "1110": "E",
                           "1111": "F"}

    '''Determine how to convert value, based and give base number'''
    def convert(self, n, val_type=int):
        if val_type == int:
            if self.base == 2:
                if any(hex_letter in str(n) for hex_letter in self.hex_letters):
                    return self.convert_to_binary_base_2_from_16(n)
                else:
                    return self.convert_to_binary_base_2_from_10(n)

            elif self.base == 10:
                if '1' in str(n) and '0' in str(n):
                    return self.convert_to_binary_base_10_from_2(n)
                else:
                    return self.convert_to_binary_base_10_from_16(n)

            elif self.base == 16:
                if '1' in str(n) and '0' in str(n):
                    return self.convert_to_binary_base_16_from_2(n)
                else:
                    return self.convert_to_binary_base_16_from_10(n)

        elif val_type == str:
            if self.base == 2:
                return ' '.join(self.ascii_to_base_2(n))

            elif self.base == 16:
                return ' '.join(self.ascii_to_base_16(n))

        else:
            raise TypeError('Type %s no supported' % str(type(val_type)))

    '''take a base2 number and convert it to its hex value'''
    def base2_to_base16(self, n):
        x = str(n)
        if len(x) <= 4:
            if '0' or '1' in x:
                if len(x) < 4:
                    for i in range(1, len(x) + 1):
                        x = '0' + x
                    return self.hex_values[x]
                elif len(x) == 4:
                    return self.hex_values[x]
        else:
            print('Cannot convert none base2 to base16')

    '''Basic method for determining how to convert a single number to binary base2'''
    @staticmethod
    def divide_by_two(n):
        i = int(n) / 2
        remainder = str(i).split('.')
        if remainder[1] == '0':
            return [int(remainder[0]), 0]
        elif remainder[1] == '5':
            return [int(remainder[0]), 1]

    '''takes each number in base2, multiplies running total by two
        and adds the current binary number in the set'''
    @staticmethod
    def doubler(n):
        a = 0
        _list = []
        if type(n) == int:
            _list = list(str(n))
        elif type(n) == str:
            _list = list(n)
        for i in _list:
            a = a * 2 + int(i)
        return a

    '''takes each number, gets its value if a hex letter, multiples by 16 to the power
        of the numbers position in the hex'''
    def power(self, n):
        _list = list(n)
        x = len(_list)
        val = 0

        '''Formula:
           decimal = d_n-1 * 16^n-1 + ... + d_1 * 16^1 + d_0 * 16^0
        '''
        for i in _list:
            x = x - 1
            if i.upper() in self.hex_letters:
               val += self.hex_letter_values[i] * int(math.pow(16, x))
            else:
               val += int(i) * int(math.pow(16, x))
        return val


    '''combines all numbers in given base10 number individually to a list of the resulting binary number,
        the resulting list is backwards'''
    def convert_to_list(self, n):
        _list = []
        i = self.divide_by_two(n)
        while True:
            a = i[0]
            b = i[1]
            if a == 0 and b == 1:
                _list.append(str(i[1]))
                break
            else:
                _list.append(str(i[1]))
                i = self.divide_by_two(i[0])
                continue
        return _list

    '''takes given base2 of base10 number and splits to a list of sets of 4 base2 numbers,
        if even groups of 4 cannot be made, 0's are added to the beginning of the
        original number till even groups of 4 can be made.'''
    def convert_to_grouped_list(self, n, b_from=2):
        base2 = None
        if b_from == 10:
            base2 = self.convert_to_binary_base_2_from_10(n)
        elif b_from == 2:
            base2 = n
        grouped_list = []
        _list = []
        if len(base2) % 4 == 0:
            _list = list(base2)
        elif len(base2) % 4 != 0:
            for i in range(4):
                base2 = "0" + base2
                if len(base2) % 4 == 0:
                    _list = list(base2)
                    break
                else:
                    continue
        for i in range(int((len(_list) / 4))):
            n_list = []
            for x in range(4):
                a = _list.pop(0)
                n_list.append(a)
            grouped_list.append(n_list)
        return grouped_list

    '''takes the grouped_list of values made by convert_to_grouped_list() and
        finds their respective hexadecimal values in the dictionary self.hex_values'''
    def convert_to_hex(self, n):
        group_list = self.convert_to_grouped_list(n, b_from=10)
        hex_list = []
        for _list in group_list:
            digit = ''.join(_list)
            value = self.hex_values[digit]
            hex_list.append(value)
        return hex_list

    '''Returns given ascii string as base2'''
    def ascii_to_base_2(self, text):
        bin_list = [format(ord(x), 'b') for x in text]
        n_list = []
        val2 = []
        for item in bin_list:
            val = self.convert_to_grouped_list(item)
            for list in val:
                val2.append(''.join(list))
            n_list.append(''.join(val2))
            val2 = []
        for item in val2:
            n_list.append(''.join(item))
        return n_list

    '''Returns given ascii string as a list of hex values'''
    def ascii_to_base_16(self, n):
        base2_list = self.ascii_to_base_2(n)
        base16_list = []
        for item in base2_list:
            base16_list.append(self.convert_to_binary_base_16_from_2(item))
        return base16_list

    '''Converts from base2 to base10'''
    def convert_to_binary_base_10_from_2(self, n):
        value = self.doubler(n)
        return value

    '''Converts from base16 to base10'''
    def convert_to_binary_base_10_from_16(self, n):
        value = self.power(n)
        return value

    '''Converts from base10 to base2, reverses resulting list to give
        correct base2 number'''
    def convert_to_binary_base_2_from_10(self, n):
        n_list = self.convert_to_list(n)
        value = ''.join(n_list[::-1])
        return value

    '''Converts from base16 to base2'''
    def convert_to_binary_base_2_from_16(self, n):
        val = self.convert_to_binary_base_10_from_16(n)
        value = self.convert_to_binary_base_2_from_10(val)
        value2 = ''
        for list in self.convert_to_grouped_list(value):
            value2 = value2 + ''.join(list)
        return value + ' or ' + value2

    '''Converts from base10 to base16'''
    def convert_to_binary_base_16_from_10(self, n):
        value = ''.join(self.convert_to_hex(n))
        return value

    '''Converts from base2 to base16'''
    def convert_to_binary_base_16_from_2(self, n):
        value = self.convert_to_grouped_list(n, b_from=2)
        hex_val = ''
        for list in value:
            hex_val = hex_val + self.hex_values[''.join(list)]
        return hex_val


'''takes base type and number / string to convert'''
def main(base, n, val_type=int):
    b = Convert(base=base)
    return b.convert(n, val_type)


if __name__ == '__main__':
    import argparse
    '''Command Line usages'''

    parser = argparse.ArgumentParser(description='Binary Covert Script and Module')
    parser.add_argument('-m', '--manual', action='store_true', help='Loads visual converter')
    parser.add_argument('-b10b2', '--base10-to-base2', nargs=1, action='store', help='Convert base10 to base2',
                        type=int)
    parser.add_argument('-b10b16', '--base10-to-base16', nargs=1, action='store', help='Convert base10 to base16',
                        type=int)
    parser.add_argument('-b2b10', '--base2-to-base10', nargs=1, action='store', help='Convert base2 to base10',
                        type=int)
    parser.add_argument('-b2b16', '--base2-to-base16', nargs=1, action='store', help='Convert base2 to base16',
                        type=int)
    parser.add_argument('-b16b2', '--base16-to-base2', nargs=1, action='store', help='Convert base16 to base2',
                        type=str)
    parser.add_argument('-b16b10', '--base16-to-base10', nargs=1, action='store', help='Convert base16 to base10',
                        type=str)
    parser.add_argument('-ascii-b2', '--ascii-to-base2', nargs=1, action='store', help='Convert ASCII string to base2',
                        type=str)
    parser.add_argument('-ascii-b16', '--ascii-to-base16', nargs=1, action='store', help='Convert ASCII string to base16',
                        type=str)


    args = vars(parser.parse_args())

    '''Assign arguments'''
    if args['ascii_to_base2']:
        print(main(2, args['ascii_to_base2'][0], val_type=str))

    if args['ascii_to_base16']:
        print(main(16, args['ascii_to_base16'][0], val_type=str))

    if args['base10_to_base2']:
        print(main(2, args['base10_to_base2'][0]))

    if args['base10_to_base16']:
        print(main(16, args['base10_to_base16'][0]))

    if args['base2_to_base10']:
        print(main(10, args['base10_to_base2'][0]))

    if args['base2_to_base16']:
        print(main(16, args['base10_to_base2'][0]))

    if args['base16_to_base2']:
        print(main(2, args['base16_to_base2'][0]))

    if args['base16_to_base10']:
        print(main(10, args['base16_to_base10'][0]))

    if args['manual']:
        '''Set up what base to convert to'''
        b_type = input('Base to convert to: ')

        '''Raise ValueError if base type is not 2, 10, or 16'''
        if int(b_type) not in [2, 10, 16]:
            raise ValueError('Unrecognized base type. Must use base of 2, 10, or 16')

        ask = input('String or Number?: ')

        if ask.lower() == 'number':
            while True:
                number = input('Enter a number to convert: ')

                '''Only here because input can be converting from base16 to base10,
                    base16 are strings. Float types not yet supported'''
                if type(number) == int:
                    print('>> ' + str(main(int(b_type), int(number))))

                elif type(number) == str:
                    print('>> ' + str(main(int(b_type), number)))

                elif type(number) == float:
                    print("Float type values not supported")

                else:
                    raise ValueError('Unrecognized value type')

        elif ask.lower() == 'string':
            while True:
                string = input('Enter a string to convert: ')

                '''Can only accept string type input'''
                if type(string) != str:
                    raise ValueError('Value must be of type int')

                elif type(string) == str:
                    print(str(main(int(b_type), string, val_type=str)))
