"""https://www.codewars.com/kata/sudoku-solution-validator/train/python"""


ROW = {'starts': [(0, y) for y in range(9)],
       'moves': [(x, 0) for x in range(9)]}

COLUMN = {'starts': [(x, 0) for x in range(9)],
          'moves': [(0, y) for y in range(9)]}

SUBGRID = {'starts': [(x, y) for x in (0, 3, 6) for y in (0, 3, 6)],
           'moves': [(x, y) for x in range(3) for y in range(3)]}


def validSolution(board):
    for shape in ROW, COLUMN, SUBGRID:
        for start in shape['starts']:
            subset_coordinates = [(start[0] + move[0], start[1] + move[1]) for move in shape['moves']]
            subset = [board[y][x] for x, y in subset_coordinates]
            if not all(num in subset for num in (1, 2, 3, 4, 5, 6, 7, 8, 9)):
                return False
    return True
