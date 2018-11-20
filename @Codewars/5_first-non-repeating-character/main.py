"""https://www.codewars.com/kata/first-non-repeating-character/train/python"""


"""v1 - Not a perfect algorithm (does `lower()` more than it has to), but at least no premature optimization"""
def first_non_repeating_letter(string):
    for char in string:
        if string.lower().count(char.lower()) == 1:
            return char
    return ''
