"""https://www.codewars.com/kata/number-of-anagrams-in-an-array-of-words/train/python"""


"""v2 - Pointless one-liner"""
# def anagram_counter(words):
#     return sum(sorted(word) == sorted(candidate) for i, word in enumerate(words) for candidate in words[i+1:])


"""v1"""
def anagram_counter(words):
    anagram_count = 0
    for i, word in enumerate(words):
        anagram_count += sum(sorted(word) == sorted(candidate) for candidate in words[i+1:])
    return anagram_count
