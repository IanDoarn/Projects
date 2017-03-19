"""
A dice game

not the stuff that comes out your ass
"""
import random

DICE_RANGE = 6
ROLL_RANGE = 2


class Crap:

    def __init__(self):
        self.current_roll = []


    @staticmethod
    def make_dice_roll():
        return [random.randint(1, DICE_RANGE) for x in range(0, ROLL_RANGE)]


if __name__ == '__main__':

    crap = Crap()

    print(crap.make_dice_roll())