"""https://www.codewars.com/kata/matrix-rotation"""

from copy import deepcopy

"""v2 - No need to cast into list"""
def rotate_clockwise(matrix):
  return [''.join(line) for line in zip(*deepcopy(matrix)[::-1])]

"""v1"""
# def rotate_clockwise(matrix):
#   return [''.join(line) for line in list(zip(*deepcopy(matrix)[::-1]))]
