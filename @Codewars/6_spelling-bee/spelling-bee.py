"""https://www.codewars.com/kata/spelling-bee/train/python"""


"""v2 - Using cool short rotate logic"""
def how_many_bees(hive):
  bee_count = 0
  if hive:
    hive_rotated = list(zip(*hive[::-1]))
    for lst in (hive, hive_rotated):
      for row in lst:
        for step in (1, -1):
          bee_count += ''.join(row[::step]).count('bee')
  return bee_count


"""v1 - Long rotating logic + workaround to get rows as strings"""
# def how_many_bees(hive):
#   hive = [''.join(row) for row in hive]
#   hive_rotated = []
#   for x in range(len(hive[0])):
#     column = ''
#     for y in range(len(hive)):
#       column += hive[y][x]
#     hive_rotated.append(column)
#
#   bee_count = 0
#   for lst in (hive, hive_rotated):
#     for row in lst:
#       bee_count += row.count('bee')
#       bee_count += row[::-1].count('bee')
#
#   return bee_count


"""Top CW solution - turns search string around rather than search area"""
# def count(it):
#   return sum(''.join(x).count('bee') + ''.join(x).count('eeb') for x in it)
#
# def how_many_bees(hive):
#   return count(hive) + count(zip(*hive)) if hive else 0


# TESTS

hive = [list("bee.bee"),
        list(".e..e.."),
        list(".b..eeb")]
print(how_many_bees(hive)) # 5

hive = [list("bee.bee"),
        list("e.e.e.e"),
        list("eeb.eeb")]
print(how_many_bees(hive)) # 8
