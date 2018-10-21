"""https://www.codewars.com/kata/scramblies/train/python"""

def scramble(s1, s2):
  return all(s1.count(char) >= s2.count(char) for char in set(s2))

# TESTS
print(scramble('rkqodlw', 'world')) # True
print(scramble('cedewaraaossoqqyt', 'codewars')) # True
print(scramble('katas', 'steak')) # False
print(scramble('scriptjava', 'javascript')) # True
print(scramble('scriptingjava', 'javascript')) # True
