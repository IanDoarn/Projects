from itertools import count

def factorial(n):
    f = 1
    for i in count(1):
        if i != n: f = f * i
        else: return f

print(factorial(3))