"""https://www.codewars.com/kata/where-my-anagrams-at/train/python"""

def anagrams(word, words):
  return [x for x in words if sorted(x) == sorted(word)]

# def anagrams(word, words):
#   return list(filter(lambda x: sorted(x) == sorted(word), words))
