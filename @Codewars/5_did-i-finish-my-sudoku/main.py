"""https://www.codewars.com/kata/did-i-finish-my-sudoku/train/python"""


"""v2 - Shorter, but less visual"""
def sub_check(matrix):
    return all(row.count(num) == 1 for num in (1, 2, 3, 4, 5, 6, 7, 8, 9) for row in matrix)

def extract_regions(board):
    regions = []
    for start_x, start_y in ((i, j) for i in (0, 3, 6) for j in (0, 3, 6)):
        region = []
        for move_x, move_y in ((i, j) for i in (0, 1, 2) for j in (0, 1, 2)):
            region.append(board[start_y + move_y][start_x + move_x])
        regions.append(region)
    return regions

def done_or_not(board):
    if all((sub_check(board),
            sub_check(list(zip(*board))),
            sub_check(extract_regions(board)))):
        return 'Finished!'
    return 'Try again!'


"""v1"""
# def sub_check(matrix):
#     for row in matrix:
#         for num in (1, 2, 3, 4, 5, 6, 7, 8, 9):
#             if row.count(num) != 1:
#                 return False
#     return True
#
#
# def extract_regions(board):
#     regions = []
#     for start_x, start_y in ((0, 0), (3, 0), (6, 0),
#                              (0, 3), (3, 3), (6, 3),
#                              (0, 6), (3, 6), (6, 6)):
#         region = []
#         for move_x, move_y in ((0, 0), (1, 0), (2, 0),
#                                (0, 1), (1, 1), (2, 1),
#                                (0, 2), (1, 2), (2, 2)):
#             region.append(board[start_y+move_y][start_x+move_x])
#         regions.append(region)
#     return regions
#
#
# def done_or_not(board):
#     if all((sub_check(board),
#             sub_check(zip(*board)),
#             sub_check(extract_regions(board)))):
#         return 'Finished!'
#     return 'Try again!'
