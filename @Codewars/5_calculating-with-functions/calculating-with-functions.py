"""https://www.codewars.com/kata/calculating-with-functions/train/python"""


from operator import add, sub, floordiv, mul
from inspect import stack

NUMS = {'zero': 0, 'one': 1, 'two': 2, 'three': 3, 'four': 4,
        'five': 5, 'six': 6, 'seven': 7, 'eight': 8, 'nine': 9}
OPS = {'plus': add, 'minus': sub, 'times': mul, 'divided_by': floordiv}

def calc(arg):
  caller = stack()[1][3]
  num = NUMS[caller]
  if not arg: return num
  else: return OPS[arg[0]](num, arg[1])

def zero(arg=None):  return calc(arg)
def one(arg=None):   return calc(arg)
def two(arg=None):   return calc(arg)
def three(arg=None): return calc(arg)
def four(arg=None):  return calc(arg)
def five(arg=None):  return calc(arg)
def six(arg=None):   return calc(arg)
def seven(arg=None): return calc(arg)
def eight(arg=None): return calc(arg)
def nine(arg=None):  return calc(arg)

def plus(num):       return (stack()[0][3], num)
def minus(num):      return (stack()[0][3], num)
def times(num):      return (stack()[0][3], num)
def divided_by(num): return (stack()[0][3], num)


# TESTS
print(five()) # 5
print(times(five())) # ('*', 5)
print(five(times(five()))) # 25
print(seven(times(five()))) # 35
print(four(plus(nine()))) # 13
print(eight(minus(three()))) # 5
print(six(divided_by(two()))) # 3
