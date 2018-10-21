"""https://projecteuler.net/problem=9

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 == c^2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
"""

"""
a < b < c
a^2 + b^2 == c^2
a + b + c == 1000
result = a*b*c
"""

from math import sqrt

"""v3"""
a, b, c, result = 2, 2, 0, None
while not result:
  while a+b+c < 1000:
      b += 1
      c = sqrt(a**2 + b**2)
      if c%1 != 0:
        continue
      if a+b+c == 1000:
        result = f"SOLUTION: a: {a}, b: {b}, c: {int(c)}, a+b+c: {int(a+b+c)}, a*b*c: {int(a*b*c)} ← ← ←"
        break
  a, b = a+1, a+1
print(result)

# """v2 - Finds solution and breaks out, but while loop would be more fitting"""
# a = 2
# result = None
# while not result:
#   for b in range(a+1, 1000):
#       c = sqrt(a**2 + b**2)
#       if c%1 != 0:
#         continue
#       if a+b+c > 1000:
#         break
#       if a+b+c == 1000:
#         result = f"SOLUTION: a: {a}, b: {b}, c: {int(c)}, a+b+c: {int(a+b+c)}, a*b*c: {int(a*b*c)} ← ← ←"
#         break
#   a += 1
# print(result)

# """v1 - Finds solution but doesn't break out"""
# for a in range(2, 1000):
#   for b in range(a+1, 1000):
#     c = sqrt(a**2 + b**2)
#     if c%1 != 0:
#       continue
#     if a+b+c > 1000:
#       break
#     if a+b+c == 1000:
#       print(f"SOLUTION: a: {a}, b: {b}, c: {int(c)}, a+b+c: {int(a+b+c)}, a*b*c: {int(a*b*c)} ← ← ←")
#       break
