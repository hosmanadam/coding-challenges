"""https://www.codewars.com/kata/unwanted-dollars/train/python"""


"""v2"""
def money_value(s):
    filtered = ''.join(char for char in s if char in '0123456789.')
    abs_value = float(filtered or '0')
    multiplier = -1 if '-' in s else 1
    return abs_value * multiplier


"""v1"""
# def money_value(s):
#     return (float(''.join([char for char in s if char in '0123456789.'] or '0'))
#             * (-1 if '-' in s else 1))
