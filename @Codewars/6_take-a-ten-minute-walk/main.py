"""https://www.codewars.com/kata/take-a-ten-minute-walk/train/python"""


"""v1 - Works, but doesn't pass the tests

- seems to be an issue with the randomized walk generation
"""
def isValidWalk(walk):
    if len(walk) == 10:
        while "e" in walk and "w" in walk:
            walk.remove("e")
            walk.remove("w")
        while "s" in walk and "n" in walk:
            walk.remove("s")
            walk.remove("n")
        if not walk:
            return True
    return False
