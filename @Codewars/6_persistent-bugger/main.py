"""https://www.codewars.com/kata/persistent-bugger/train/python"""

def persistence(n):
    count = 0
    while n > 9:
        count += 1
        n = eval('*'.join(str(n)))
    return count
