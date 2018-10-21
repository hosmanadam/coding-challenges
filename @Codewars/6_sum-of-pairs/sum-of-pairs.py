"""https://www.codewars.com/kata/sum-of-pairs/train/python"""

def sum_pairs(ints, s):
  """My solution, OK but not best"""
  # maximize appearance of each number to a count of 2
  seen = []
  ints = [x for x in ints if not (seen.count(x) > 1 or seen.append(x))]
  # find first pair
  for y in range(1, len(ints)):
    for x in range(y):
      if ints[x] + ints[y] == s:
        return [ints[x], ints[y]]

# def sum_pairs(lst, s):
#   """Top CW solution
#   - doesn't uniquify entire list, just the part up to current num, in increments
#   - algorithm described here: https://coderbyte.com/algorithm/two-sum-problem"""
#   cache = set()
#   for i in lst:
#     if s - i in cache:
#       return [s - i, i]
#     cache.add(i)
