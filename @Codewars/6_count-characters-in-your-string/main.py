"""https://www.codewars.com/kata/count-characters-in-your-string/train/python"""


"""v2"""
from collections import Counter

def count(string):
    return Counter(string)


"""v1"""
# def count(string):
#     return {char:string.count(char) for char in set(string)}
