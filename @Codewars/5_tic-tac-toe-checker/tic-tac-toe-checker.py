"""https://www.codewars.com/kata/tic-tac-toe-checker/train/python"""

def isSolved(board):
  shapes = {"ud":   {"step_y": 1, "step_x": 0},
            "lr":   {"step_y": 0, "step_x": 1},
            "ullr": {"step_y": 1, "step_x": 1},
            "urll": {"step_y": 1, "step_x": -1}}

  for shape in shapes.values():
    for y in range(3):
      for x in range(3):
        try:
          marks = [board[y + shape["step_y"]*i][x + shape["step_x"]*i] for i in range(3)]
          if marks in ([1, 1, 1], [2, 2, 2]):
            return marks[0]
        except IndexError: continue
  if 0 not in board[0]+board[1]+board[2]: return 0
  return -1


# def isSolved(board):
#   """One of many CW solutions:
#   - game is a tie if all possible rows have marks from both players"""
#   rows = board
#   cols = zip(*board)
#   dgls = [[board[i*j][i*j] for i in range(3)] for j in [1,-1]]
#
#   lines = rows+cols+dgls
#
#   if all(2 in line and 1 in line for line in lines):
#       return 0
#   if any(line == [1]*3 for line in lines):
#       return 1
#   if any(line == [2]*3 for line in lines):
#       return 2
#  
#   return -1


# TESTS

board = [[0, 0, 1],
         [0, 1, 2],
         [2, 1, 0]]
print(isSolved(board)) # -1

board = [[1, 1, 1],
         [0, 2, 2],
         [0, 0, 0]]
print(isSolved(board)) # 1

board = [[2, 1, 2],
         [2, 1, 1],
         [1, 1, 2]]
print(isSolved(board)) # 1

board = [[2, 1, 2],
         [2, 1, 1],
         [1, 2, 1]]
print(isSolved(board)) # 0
