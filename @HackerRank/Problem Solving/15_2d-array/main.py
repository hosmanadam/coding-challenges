"""https://www.hackerrank.com/challenges/2d-array/problem"""

#!/bin/python3

import os


def hourglassSum(arr):
    return max(get_hourglass_sum(arr, row, col) for row in range(len(arr)-2) for col in range(len(arr[0])-2))


def get_hourglass_sum(arr, row, col):
    hourglass = ((0, 0), (0, 1), (0, 2),
                         (1, 1),
                 (2, 0), (2, 1), (2, 2))

    sum = 0
    for row_offset, col_offset in hourglass:
        sum += arr[row+row_offset][col+col_offset]
    return sum


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
