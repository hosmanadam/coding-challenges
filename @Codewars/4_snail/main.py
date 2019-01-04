"""https://www.codewars.com/kata/snail/train/python"""


"""v3 - Even more creative, even less efficient"""
def snail(array):
    matrix = array.copy()
    result = []
    while matrix:
        result += matrix.pop(0)
        matrix = [[row[i] for row in matrix] for i in range(len(matrix[0])-1, -1, -1)] if matrix else []
    return result


"""v2 - A bit more creative, probably less efficient on a large scale"""
# def snail(array):
#     matrix = array.copy()
#     result = []
#     while True:
#         try:
#             result += matrix.pop(0)
#             result += [row.pop(-1) for row in matrix]
#             result += matrix.pop(-1)[::-1]
#             result += [row.pop(0) for row in matrix][::-1]
#         except IndexError:
#             break
#     return result


"""v1 - Very literal"""
# def snail(array):
#     valid_indexes = range(len(array[0]))
#     visited = []
#     current_row, current_col = 0, -1
#     snail_values = []
#     while len(visited) < len(array[0])**2:                                       # circles
#         for move_row, move_col in (0, 1), (1, 0), (0, -1), (-1, 0):              # right, down, left, up
#             next_row, next_col = current_row + move_row, current_col + move_col
#             while ((next_row, next_col) not in visited and                       # straight
#                    next_row in valid_indexes and
#                    next_col in valid_indexes):
#                 current_row, current_col = next_row, next_col
#                 snail_values.append(array[current_row][current_col])
#                 visited.append((current_row, current_col))
#                 next_row, next_col = current_row + move_row, current_col + move_col
#     return snail_values


"""Top CW solution - Recursive, because fractal... Doh!"""
# def snail(array):
#     return list(array[0]) + snail(zip(*array[1:])[::-1]) if array else []


"""Top CW solution - Rotated using NumPy"""
# import numpy as np
#
# def snail(array):
#     m = []
#     array = np.array(array)
#     while len(array) > 0:
#         m += array[0].tolist()
#         array = np.rot90(array[1:])
#     return m

"""Top CW solution - Rotated using zip()"""
# def snail(array):
#     out = []
#     while len(array):
#         out += array.pop(0)
#         array = list(zip(*array))[::-1] # Rotate
#     return out
