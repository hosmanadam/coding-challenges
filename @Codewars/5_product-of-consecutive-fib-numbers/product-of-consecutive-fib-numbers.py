"""https://www.codewars.com/kata/product-of-consecutive-fib-numbers/train/python"""

from math import sqrt

"""v2 - Needless complication"""
# from operator import mul
# def productFib(prod):
#   fib = make_fib(prod)
#   for i in range(len(fib)-1):
#     lst = fib[i:i+2]
#     if mul(*lst) == prod:
#       return lst + [True]
#     if mul(*lst) > prod:
#       return lst + [False]

"""v1"""
def productFib(prod):
  fib = make_fib(prod)
  for i in range(len(fib)-1):
    if fib[i] * fib[i+1] == prod:
      return [fib[i], fib[i+1], True]
    if fib[i] * fib[i+1] > prod:
      return [fib[i], fib[i+1], False]

def make_fib(limit, start=[0, 1]):
  """Copied from `adam.py` and simplified"""
  new = sum(start[-2:])
  if new > limit:
    return start
  start.append(new)
  return make_fib(limit, start)


"""Top CW solution - only does what's needed"""
# def productFib(prod):
#   a, b = 0, 1
#   while prod > a * b:
#     a, b = b, a + b
#   return [a, b, prod == a * b]


# TESTS
print(productFib(100))
