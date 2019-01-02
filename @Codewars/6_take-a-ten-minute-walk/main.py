"""https://www.codewars.com/kata/take-a-ten-minute-walk/train/python"""


"""v2 - Works and passes the tests"""
# def isValidWalk(walk):
#     walk = walk.copy()
#     if len(walk) == 10:
#         while "e" in walk and "w" in walk:
#             walk.remove("e")
#             walk.remove("w")
#         while "s" in walk and "n" in walk:
#             walk.remove("s")
#             walk.remove("n")
#         if not walk:
#             return True
#     return False


"""v1 - Works, but doesn't pass the tests

- seems to be an issue with the randomized walk generation
"""
# def isValidWalk(walk):
#     if len(walk) == 10:
#         while "e" in walk and "w" in walk:
#             walk.remove("e")
#             walk.remove("w")
#         while "s" in walk and "n" in walk:
#             walk.remove("s")
#             walk.remove("n")
#         if not walk:
#             return True
#     return False


"""Top CW solution

- could've seen this coming
"""
# def isValidWalk(walk):
#     return len(walk) == 10 and walk.count('n') == walk.count('s') and walk.count('e') == walk.count('w')


"""Top CW solution

- suggested best practice
- only iterates through list twice
"""
# from collections import Counter
#
# def isValidWalk(walk):
#     c = Counter(walk)
#     return len(walk) == 10 and c['e'] == c['w'] and c['n'] == c['s']
