"""https://www.codewars.com/kata/upside-down-numbers/train/python"""

import math

OPPOSITES = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}


"""v2 - Pointless three-liner"""
def solve(a, b):
    return sum(((all(n in OPPOSITES for n in str(n)) and
                 all(OPPOSITES[str(n)[i]] == str(n)[-i-1] for i in range(math.ceil(len(str(n))/2)))))
               for n in range(a, b))


"""v1"""
def solve(a, b):
    count = 0
    for num in range(a, b):
        string = str(num)
        count += ((all(n in OPPOSITES for n in string) and
                   all(OPPOSITES[string[i]] == string[-i-1] for i in range(math.ceil(len(string)/2)))))
    return count
