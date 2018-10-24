"""https://www.codewars.com/kata/double-cola/train/python"""

"""v4 - Remade v3 into a needless one-liner"""
# def whoIsNext(names, r):
#   return names[r-1] if r <= len(names) else whoIsNext(names, (r-(len(names)-1))//2)


"""v3 - Remade top CW solution as dynamic and recursive for practice"""
# def whoIsNext(names, r):
#   if r <= len(names):
#     return names[r-1]
#   return whoIsNext(names, (r-(len(names)-1))//2)


"""v2 - Smarter, doesn't duplicate list elements but assigns number instead"""
def whoIsNext(names, r):
  names = [{'name': name, 'count': 1} for name in names]
  while True:
    cache = names[0]['count']
    if cache < r:
      r -= cache
      names[0]['count'] *= 2
      names.append(names.pop(0))
    else:
      return names[0]['name']


"""v1 - Works, but way too slow"""
# def whoIsNext(names, r):
#   for r in range(r-1):
#     names += [names.pop(0)]*2
#   return names[0]


"""Top CW solution

I took it too literally:
- no need to keep placing ppl from 0 to -1 in the queue:
  you can just make the queue `r` long and look at the `r`th element
- but this doesn't even do that:
  - works on `r` instead of names
  - if `r` is less than len(names), returns `r`th element
  - if `r` is more, reduces `r` (by thowing away 4 and halving) instead of expanding list
"""
# def whoIsNext(names, r):
#   while r > 5:
#     r = (r - 4) // 2
#   return names[r-1]


# TESTS
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 1)) # Sheldon
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 52)) # Penny
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 7230702951)) # Leonard
