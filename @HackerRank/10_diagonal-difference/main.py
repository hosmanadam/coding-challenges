"""https://www.hackerrank.com/challenges/diagonal-difference/problem"""


def diagonalDifference(arr):
    size = len(arr)
    lr_sum = sum(arr[i][i] for i in range(size))
    rl_sum = sum(arr[i][-i-1] for i in range(size))
    return abs(lr_sum-rl_sum)


arr = [[1, 2, 3], [4, 5, 6], [9, 8, 9]]  # 2
print(diagonalDifference(arr))

arr = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]  # 15
print(diagonalDifference(arr))
