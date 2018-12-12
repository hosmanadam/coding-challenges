"""https://www.codewars.com/kata/string-character-frequency/train/python"""


"""v2 - Useless two-liner"""
# def solve(s):
#     is_same_count = lambda string: len(set(string.count(char) for char in set(string))) == 1
#     return any(is_same_count(s.replace(letter, '', 1)) for letter in set(s))


"""v1"""
def is_same_count(string):
    return len(set(string.count(char) for char in set(string))) == 1

def solve(s):
    return any(is_same_count(s.replace(letter, '', 1)) for letter in set(s))
