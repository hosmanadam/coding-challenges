"""https://www.codewars.com/kata/sudoku-solution-validator/train/python"""


ROW = {'starts': [(row, 0) for row in range(9)],
       'moves': [(0, col) for col in range(9)]}

COLUMN = {'starts': [(0, col) for col in range(9)],
          'moves': [(row, 0) for row in range(9)]}

SUBGRID = {'starts': [(row, col) for col in (0, 3, 6) for row in (0, 3, 6)],
           'moves': [(row, col) for col in range(3) for row in range(3)]}


def validSolution(board):
    for shape in ROW, COLUMN, SUBGRID:
        for start in shape['starts']:
            subset_coordinates = [(start[0] + move[0], start[1] + move[1]) for move in shape['moves']]
            subset = [board[row][col] for row, col in subset_coordinates]
            if not all(num in subset for num in (1, 2, 3, 4, 5, 6, 7, 8, 9)):
                return False
    return True
