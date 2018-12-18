"""https://www.codewars.com/kata/find-the-parity-outlier/train/python"""


def find_outlier(integers):
    evens, odds = [], []
    for n in integers:
        if n % 2 == 0:
            evens.append(n)
        else:
            odds.append(n)
        if evens and odds:
            if len(evens) > len(odds):
                return odds[0]
            if len(evens) < len(odds):
                return evens[0]
