"""https://www.codewars.com/kata/find-the-odd-int/train/python"""

def find_it(seq):
    for num in seq:
        if seq.count(num) % 2 == 1:
            return num
