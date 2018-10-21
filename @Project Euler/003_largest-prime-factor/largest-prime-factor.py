"""https://projecteuler.net/problem=3

The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
"""

from math import sqrt

def largest_prime_factor(product):
  """My best version from Udemy course modded to fit"""
  prime_set = set()
  candidate = 2
  while candidate <= sqrt(product):
    if 600851475143 % candidate == 0:
      for divisor in range(2, round(sqrt(candidate))+1):
        if candidate%divisor == 0 and divisor != 1:
          break
      else:
        prime_set.add(candidate)
    candidate += 1
  return max(prime_set)

print(largest_prime_factor(600851475143))


# def prime_generator(max):
#   """General version for possible reuse.
#   Generates prime numbers until their value reaches max.
#   NOW IN ADAM.PY"""
#   candidate = 2
#   while candidate <= max:
#     for divisor in range(2, round(sqrt(candidate))+1):
#       if candidate%divisor == 0 and divisor != 1:
#         break
#     else:
#       yield candidate
#     candidate += 1
