def convertMillis(ms):
    x = ms / 1000
    seconds = x % 60
    x /= 60
    minutes = x % 60
    x /= 60
    hours = x
    x /= 24
    days = x

    print("{}:{}:{}".format(str(int(hours)),
                            str(int(minutes)),
                            str(int(seconds))))


