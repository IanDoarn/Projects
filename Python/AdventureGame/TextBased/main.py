from animations.text import TextAnimation as txtanim
from story.storytext import LoadStory as ldstory

class Intro:

    @staticmethod
    def start():
        """ Load intro text and animate printing"""
        txtanim.animated_print(txtanim.string_to_char_array(ldstory.introduction()))

Intro.start()