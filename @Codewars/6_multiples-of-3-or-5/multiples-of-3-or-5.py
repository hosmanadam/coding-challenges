"""https://www.codewars.com/kata/514b92a657cdc65150000006/train/python"""

def solution(number):
  """v2 - One-linerized version of the same"""
  return sum({n for n in range(number) if n%3==0 or n%5==0})

# def solution(number):
#   """v1 - Copy of my Project Euler solution, modified to take dynamic max. value"""
#   multiples_of_3_or_5 = set()
#   for n in range(number):
#     if n%3==0 or n%5==0:
#       multiples_of_3_or_5.add(n)
#   return sum(multiples_of_3_or_5)
