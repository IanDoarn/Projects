class LoadStory:

    @staticmethod
    def introduction():
        text = None
        with open('story.txt', 'r')as f:
            text = f.read().replace('\n', '')
        f.close()
        return text
