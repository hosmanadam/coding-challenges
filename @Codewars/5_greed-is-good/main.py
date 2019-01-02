"""https://www.codewars.com/kata/greed-is-good/train/python"""


SCORE_TABLE = (
    (1, 3, 1000),
    (6, 3, 600),
    (5, 3, 500),
    (4, 3, 400),
    (3, 3, 300),
    (2, 3, 200),
    (1, 1, 100),
    (5, 1, 50),
)


def score(dice):
    throw = dice.copy()
    points = 0
    for num, cnt, pts in SCORE_TABLE:
        while throw.count(num) >= cnt:
            points += pts
            for i in range(cnt):
                throw.remove(num)
    return points
