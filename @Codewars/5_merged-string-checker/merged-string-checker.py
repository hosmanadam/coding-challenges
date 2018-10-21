"""https://www.codewars.com/kata/merged-string-checker/train/python"""

def is_merge(s, part1, part2):
  """Hard to read, but DRY
  - uses `eval()` to loop through numbered variables
  - recognizes that `part1` & `part2` can be switched"""
  if len(s) != len(part1+part2): return False
  if s == part1+part2: return True
  for i in (1, 2):
    part = eval(f'part{i}')
    if part and s[0] == part[0]:
      if is_merge(s[1:], part[1:], eval(f'part{i%2+1}')):
        return True
  return False

# TESTS
print(is_merge('codewars', 'code', 'wars')) # True
print(is_merge('codewars', 'cdw', 'oears')) # True
print(is_merge('codewars', 'cod', 'wars')) # False
print(is_merge('', 'cod', 'wars')) # False
print(is_merge('warse', '', 'warss')) # False
