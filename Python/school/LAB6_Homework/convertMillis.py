def convertMillis(ms):
    """
    Converts a given number of milliseconds
    to hours, minutes, seconds.

    prints to the console in the format

    HH:MM:SS

    :param ms: integer in milliseconds
    :return: pack variables of Hours, Minutes, Seconds
    """

    # Set x to milliseconds divided by 1000
    # converting it to whole seconds
    x = ms / 1000

    # Round to the nearest second
    seconds = x % 60

    # divide by 60 to get minutes
    x /= 60

    # Round to the nearest minute
    minutes = x % 60

    # divide by 60 to get hours
    x /= 60

    hours = x

    # Print result in HH:MM:SS
    print("{}:{}:{}".format(str(int(hours)),
                            str(int(minutes)),
                            str(int(seconds))))

    return hours, minutes, seconds

