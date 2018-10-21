"""https://www.codewars.com/kata/counting-change-combinations/train/python

This has to do with Partition Theory: https://en.wikipedia.org/wiki/Partition_(number_theory)
Which is a subfield of Combinatorics: https://en.wikipedia.org/wiki/Combinatorics
Deconstruction of the specific problem: http://www.algorithmist.com/index.php/Coin_Change

TODO: eliminate recursion
"""

"""v2 - similar with everything returned, but doesn't work yet"""

# def partition(money, coins, combination=[]):
#   """Works only when coins are sorted in ascending order.
#   Lists are going downstream (so expansion can take place),
#   sets of tuples are coming upstream (so no duplication is allowed)."""
#   for coin in coins:
#     new_sum = sum(combination)+coin
#     if new_sum == money:
#       return {tuple(sorted(combination+[coin]))} # return a set of one solution (may be duplicate)
#     elif new_sum > money:
#       return {None}                              # return a set of nothing (nothing else to do here)
#     else:
#       next_depth = set()
#       for coin in coins:
#         for solution in partition(money, coins, combination+[coin]):
#           if solution:
#             next_depth.add(solution)             # remove duplication in lower levels
#       # BUG: Doesn't work because highest level is only ever the first coin!
#       #      Could add a top level that forks out the same way...
#       return next_depth                          # return solutions from lower levels

# def count_change(money, coins):
#   combinations = partition(money, sorted(coins))
#   # return len(combinations)
#   return combinations


"""v1 - ugly but it works with small inputs"""

def count_change(money, coins):
  partitions = set()
  def partition(money, coins, combination=[]):
    for coin in coins:
      new_sum = sum(combination)+coin
      if new_sum == money:
        partitions.add(tuple(sorted(combination+[coin])))
        break
      elif new_sum < money:
        partition(money, coins, combination+[coin])
  partition(money, sorted(coins))
  return len(partitions)


# TESTS
print(count_change(4, [1,2])) # 3
print(count_change(10, [5,2,3])) # 4
print(count_change(11, [5,7])) # 0
