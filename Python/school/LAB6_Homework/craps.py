"""
A dice game

not the stuff that comes out your ass
"""
import random

DICE_RANGE = 6
ROLL_RANGE = 2


class Crap:

    def __init__(self):
        self.current_sum = 0
        self.first_roll = True

    @staticmethod
    def make_dice_roll():
        return [random.randint(1, DICE_RANGE) for x in range(0, ROLL_RANGE)]

    def sum_roll(self, roll):
        """
        Take the list of two dice rolls and
        sum them together and return the sum

        :param roll: list object of rolls
        :return: sum of the two rolls
        """

        return roll[0] + roll[1]

    def check_sum(self, roll_sum, roll):
        """
        Basic logic for checking
        the players score

        :param roll_sum: sum of the players roll
        :param roll: current roll player has
        :return: returns true if you won, false if you lose, and None if the game isn't over
        """

        # Print a visual of what the players sum is

        current_sum = self.current_sum

        if self.first_roll == True:
            print("You rolled {} + {} = {}".format(str(roll[0]), str(roll[1]), str(roll_sum)))
        else:
            print("You rolled {} + {} = {}".format(str(roll[0]), str(roll[1]), str(roll_sum)))
            new_roll_sum = roll_sum + current_sum
            print("Current score is {}".format(str(roll_sum)))
            roll_sum = new_roll_sum

        # Craps
        if roll_sum in [2, 3, 12]:
            return False

        # Natural
        elif roll_sum in [7, 11] and self.first_roll == True:
            return True

        # this is the second roll and the sum is 7
        elif self.first_roll != True and roll_sum == 7:
            return False

        # if your sum is this then play again
        elif roll_sum in [4, 5, 6, 8, 9, 10]:
            print("point is {}".format(str(roll_sum)))
            self.first_roll = False
            self.current_sum = sum
            return None

        elif self.first_roll != True and roll_sum == self.current_sum:
            return True

        else:
            return False

if __name__ == '__main__':

    crap = Crap()

    while True:
         roll = crap.make_dice_roll()
         roll_sum = crap.sum_roll(roll)
         result = crap.check_sum(roll_sum, roll)

         if result == None:
             pass

         elif result == True:
             print("You win")
             break

         elif result == False:
             print("You lose")
             break