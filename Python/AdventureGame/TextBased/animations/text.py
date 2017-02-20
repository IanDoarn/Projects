import time
import sys


class TextAnimation:

    @staticmethod
    def string_to_char_array(string):
        return list(string)

    @staticmethod
    def animated_print(char_array, delay=0.1, pause=1,newline_after=True):
        for char in char_array:
            print(char, end='')
            sys.stdout.flush()
            if char in ('.', '!', '?'):
                time.sleep(pause)
            else:
                time.sleep(delay)
        print('\n') if newline_after is True else None
