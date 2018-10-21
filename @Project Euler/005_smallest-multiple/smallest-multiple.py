"""https://projecteuler.net/problem=5

2520 is the smallest number that can be divided by each of the numbers
from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by
all of the numbers from 1 to 20?
"""

def lowest_common_multiple(largest_divisor):
  """v3 - awesome recursive optimization"""
  if largest_divisor == 1:
    return 1
  increment = lowest_common_multiple(largest_divisor-1)
  num = increment
  while True:
    if all(num%x == 0 for x in range(1, largest_divisor+1)):
      return num
    num += increment

print(lowest_common_multiple(20))


# """v2 - I got 2520 from SarumanUncloaked who got it from the first half of assignment"""
# num = 2520
# while True:
#   print(num)
#   if all(num%x == 0 for x in range(1, 21)):
#     break
#   num += 2520


# """v1 -  I realized to step by 20s"""
# num = 20
# while True:
#   print(num)
#   if all(num%x == 0 for x in range(1, 21)):
#     break
#   num += 20
