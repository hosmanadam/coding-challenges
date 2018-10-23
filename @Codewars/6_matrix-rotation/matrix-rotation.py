"""https://www.codewars.com/kata/matrix-rotation"""

from copy import deepcopy

def rotate_clockwise(matrix):
  """v2 - No need to cast into list"""
  return [''.join(line) for line in zip(*deepcopy(matrix)[::-1])]

# def rotate_clockwise(matrix):
#   """v1"""
#   return [''.join(line) for line in list(zip(*deepcopy(matrix)[::-1]))]
