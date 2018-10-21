"""https://www.codewars.com/kata/simple-equation-reversal/train/python"""

import re

def solve(eq):
  return ''.join(re.findall(r'\w+|\W+', eq)[::-1])

# TESTS
print(solve("100*b/y")) # "y/b*100"
print(solve("a+b-c/d*30")) # "30*d/c-b+a"
print(solve("a*b/c+50")) # "50+c/b*a"
