import random

ATTRIBUTES = {'qualities': {'new': 5,
                            'used': 4,
                            'worn': 3,
                            'battle-test': 2,
                            'fragile': 1},
               'rarity': {'legendary': 5,
                          'mythic': 4,
                          'special': 3,
                          'uncommon': 2,
                          'common': 1}}
WEAPONS = {'one-handed': ['axe',
                          'sword',
                          'dagger',
                          'sheild'],
            'two-handed': ['broadsword',
                           'bow',
                           'claidheimor',
                           'battleaxe']}


class Weapon:

    def __init__(self, player_lvl, attributes=ATTRIBUTES, weapons=WEAPONS):
        self.player_level = player_lvl
        self.attr = attributes
        self.weps = weapons

    """This will determine what the level of the weapon generate will be."""
    def determine_weapon_level(self, diff=3):
        return random.randrange(self.player_level - diff , self.player_level + diff)

    def determine_weapon_type(self):
