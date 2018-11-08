"""https://www.codewars.com/kata/first-n-prime-numbers"""


"""v2 - Takes memoization to next level via class attributes (6x faster in CC random tests)"""

from math import sqrt

class Primes:

  confirmed = [2]
  candidate = 3

  @classmethod
  def first(cls, count):
    while len(cls.confirmed) < count:
      for divisor in cls.confirmed:
        if divisor > sqrt(cls.candidate):
          cls.confirmed.append(cls.candidate)
          break
        if cls.candidate%divisor == 0:
          break
      cls.candidate += 2
    return cls.confirmed[:count]


"""v1 - Copied from adam.py, stripped unneeded features, turned into class method"""
#
# from math import sqrt
#
# class Primes:
#
#   @classmethod
#   def first(cls, count):
#     cls.confirmed = [2]
#     candidate = 3
#     while len(cls.confirmed) < count:
#       for divisor in cls.confirmed:
#         if divisor > sqrt(candidate):
#           cls.confirmed.append(candidate)
#           break
#         if candidate%divisor == 0:
#           break
#       candidate += 2
#     return cls.confirmed


# TESTS
print(Primes.first(1))  # [2]
print(Primes.first(2))  # [2, 3]
print(Primes.first(5))  # [2, 3, 5, 7, 11]
print(Primes.first(20)[-5:])  # [53, 59, 61, 67, 71]
print(Primes.first(100)[99])  # 541
print(Primes.first(80)[79])  # 409
