"""https://www.codewars.com/kata/bowling-pins/train/python"""


"""v1 - OK but kind of unnecesarily dynamic-ish"""
def bowling_pins(arr):
  pins = list("I I I I\n I I I \n  I I  \n   I   ")
  nums = (n for n in (7, 8, 9, 10, 4, 5, 6, 2, 3, 1))
  indexes = [char if char != 'I' else next(nums) for char in pins]
  for hit in arr:
    pins[indexes.index(hit)] = ' '
  return ''.join(pins)


"""Top CW solution

- broken up by meaningful blocks instead of by character
- this enabled hard-coding before-after lists, making the function more readable
"""
# def bowling_pins(empty):
#   raw =     ['I ', 'I ', 'I ', 'I\n', ' I', ' I ', 'I \n', '  I ', 'I  \n', '   I   ']
#   replace = ['  ', '  ', '  ', ' \n', '  ', '   ', '  \n', '    ', '   \n', '       ']
#   order = [7, 8, 9, 10, 4, 5, 6, 2, 3, 1]
#
#   return ''.join([replace[x] if order[x] in empty else raw[x] for x in xrange(10)])


# TESTS
print(bowling_pins([2,3])) # "I I I I\n I I I \n       \n   I   "
print(bowling_pins([1,2,10])) # "I I I  \n I I I \n    I  \n       "
