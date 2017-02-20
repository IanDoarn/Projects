import random


class RollTheDice:

    def __init__(self, sides=6, turns=10 ,player1='Computer', player2='User'):
        self.sides = sides
        self.turns = turns
        self.player1 = player1
        self.player2 = player2
        self.player1_score = 0
        self.player2_score = 0

    def game(self):
        current_turn = 1

        while current_turn <= self.turns:
            if input("Roll? <Y/N> ").lower() != 'n':

                player1_roll = random.randrange(1, self.sides)
                player2_roll = random.randrange(1, self.sides)

                if player1_roll > player2_roll:
                    print('[{}] rolled a [{}] and [{}] rolled a [{}]! [{}] won!'.format(self.player1, str(player1_roll),
                                                                                        self.player2, str(player2_roll),
                                                                                        self.player1))
                    self.player1_score += 1
                elif player1_roll < player2_roll:
                    print('[{}] rolled a [{}] and [{}] rolled a [{}]! [{}] won!'.format(self.player1, str(player1_roll),
                                                                                        self.player2, str(player2_roll),
                                                                                        self.player2))
                    self.player2_score += 1
                elif player1_roll == player2_roll:
                    print('[{}] and [{}] rolled [{}]! Nobody won!'.format(self.player1, self.player2, str(self.player1_score)))

                current_turn += 1
            else:
                if self.player1_score > self.player2_score:
                    print('[{}] won with [{}] points! [{}] points more than [{}]'.format(self.player1,
                                                                                         str(self.player1_score),
                                                                                         str(self.player1_score - self.player2_score),
                                                                                         self.player2))
                elif self.player1_score < self.player2_score:
                    print('[{}] won with [{}] points! [{}] points more than [{}]'.format(self.player2,
                                                                                         str(self.player1_score),
                                                                                         str(self.player1_score - self.player2_score),
                                                                                         self.player1))
                break

if __name__ == '__main__':
    rtd = RollTheDice()
    rtd.game()



