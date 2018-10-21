"""https://www.codewars.com/kata/double-cola/train/python"""

# def whoIsNext(names, r):
#   """v4 - Remade v3 into a needless one-liner"""
#   return names[r-1] if r <= len(names) else whoIsNext(names, (r-(len(names)-1))//2)

# def whoIsNext(names, r):
#   """v3 - Remade top CW solution as dynamic and recursive for practice."""
#   if r <= len(names):
#     return names[r-1]
#   return whoIsNext(names, (r-(len(names)-1))//2)

def whoIsNext(names, r):
  """v2 - Smarter, doesn't duplicate list elements but assigns number instead"""
  names = [{'name': name, 'count': 1} for name in names]
  while True:
    cache = names[0]['count']
    if cache < r:
      r -= cache
      names[0]['count'] *= 2
      names.append(names.pop(0))
    else:
      return names[0]['name']

# def whoIsNext(names, r):
#   """v1 - Works, but way too slow"""
#   for r in range(r-1):
#     names += [names.pop(0)]*2
#   return names[0]

# def whoIsNext(names, r):
#   """Top CW solution by Spencer-Zhang, magnert, Yazan24:
#   - I took it too literally:
#     There's no need to keep placing ppl from 0 to -1 in the queue
#     You can just make the queue `r` long and look at the `r`th element
#   - But this doesn't even do that: works on `r` instead of names
#   - If `r` is less than len(names), returns `r`th element
#     If `r` is more, reduces `r` (by thowing away 4 and halving) instead of expanding list"""
#   while r > 5:
#     r = (r - 4) // 2
#   return names[r-1]


# TESTS
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 1)) # Sheldon
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 52)) # Penny
print(whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 7230702951)) # Leonard
