"""https://www.codewars.com/kata/ascii-letters-from-number/train/python"""


def convert(number):
    nums = [number[i:i+2] for i in range(0, len(number), 2)]
    return ''.join(chr(int(num)).upper() for num in nums)
