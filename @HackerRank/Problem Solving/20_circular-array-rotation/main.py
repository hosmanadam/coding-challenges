"""https://www.hackerrank.com/challenges/circular-array-rotation/problem"""


def circularArrayRotation(a, k, queries):
    a_rotated = [a[i - (k % len(a))] for i in range(len(a))]
    return [a_rotated[i] for i in queries]
