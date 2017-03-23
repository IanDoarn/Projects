import random
numbers = [random.randint(1, 99) for n in range(0, 99)]
drawn = [random.choice(numbers) for x in range(1, 6)]

print("Numbers drawn: {}".format(str(drawn).strip("[]")))

number_of_picks = 1

print("Begin picking.")

while(True):
    picked = [random.choice(numbers) for i in range(1, 6)]

    if picked == drawn:
        print("You won after {} iterations. You're winning numbers: {}".format(str(number_of_picks),
                                                                               str(picked).strip("[]")))
        break
    else:
        if number_of_picks % 1000000 == 0:
            print("Iteration: {}".format(str(number_of_picks)))
        number_of_picks += 1
