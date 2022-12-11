"""https://adventofcode.com/2022/day/8"""

import doctest

INPUT_FILENAME = 'puzzle_input.txt'


# INPUT_FILENAME = 'puzzle_input_sample.txt'


def get_trees_to_the_left(trees, row, col):
    """
    :return: List of trees to the 'left' of the tree at the given indexes, in order from closest to farthest

                                                                  ↓  ↓  ↓  ⚑
    >>> get_trees_to_the_left([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 2, 3)
    [3, 5, 6]
    """
    return trees[row][:col][::-1]


def get_trees_to_the_right(trees, row, col):
    """
    :return: List of trees to the 'right' of the tree at the given indexes, in order from closest to farthest

                                                                      ⚑  ↓  ↓  ↓
    >>> get_trees_to_the_right([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 2, 1)
    [3, 3, 2]
    """
    return trees[row][col + 1:]


def get_trees_above(trees, row, col):
    """
    :return: List of trees 'above' the tree at the given indexes, in order from closest to farthest

                             ↓                ↓                ⚑
    >>> get_trees_above([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 2, 1)
    [5, 0]
    """
    return [trees[other_row][col] for other_row in range(row)][::-1]


def get_trees_below(trees, row, col):
    """
    :return: List of trees 'below' the tree at the given indexes, in order from closest to farthest

                                                               ⚑                ↓                ↓
    >>> get_trees_below([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 2, 1)
    [3, 5]
    """
    return [trees[other_row][col] for other_row in range(row + 1, len(trees))]


def is_visible_from_outside(trees, row, col):
    """
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 0, 0)
    True
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 0, 4)
    True
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 4, 0)
    True
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 4, 4)
    True
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 1, 1)
    True
    >>> is_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 2, 2)
    False
    """
    candidate = trees[row][col]
    return (row in (0, len(trees) - 1) or
            col in (0, len(trees[0]) - 1) or
            max(get_trees_to_the_left(trees, row, col)) < candidate or
            max(get_trees_to_the_right(trees, row, col)) < candidate or
            max(get_trees_above(trees, row, col)) < candidate or
            max(get_trees_below(trees, row, col)) < candidate)


def count_trees_visible_from_outside(trees):
    """
    >>> count_trees_visible_from_outside([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]])
    21
    """
    return sum([is_visible_from_outside(trees, row, col) for row in range(len(trees)) for col in range(len(trees[0]))])


def count_trees_visible_in_direction(trees_in_direction, max_visible_height):
    """
    >>> count_trees_visible_in_direction([3, 0, 3, 7, 3], 2)
    1
    >>> count_trees_visible_in_direction([3, 0, 3, 7, 3], 5)
    4
    >>> count_trees_visible_in_direction([3, 0, 3, 7, 3], 9)
    5
    """
    for i in range(len(trees_in_direction)):
        if trees_in_direction[i] >= max_visible_height:
            return i + 1

    return len(trees_in_direction)


def calculate_scenic_score(trees, row, col):
    """
    >>> calculate_scenic_score([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 1, 2)
    4
    >>> calculate_scenic_score([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]], 3, 2)
    8
    """
    max_visible_height = trees[row][col]
    return (count_trees_visible_in_direction(get_trees_to_the_left(trees, row, col), max_visible_height) *
            count_trees_visible_in_direction(get_trees_to_the_right(trees, row, col), max_visible_height) *
            count_trees_visible_in_direction(get_trees_above(trees, row, col), max_visible_height) *
            count_trees_visible_in_direction(get_trees_below(trees, row, col), max_visible_height))


def calculate_max_scenic_score(trees):
    """
    >>> calculate_max_scenic_score([[3, 0, 3, 7, 3], [2, 5, 5, 1, 2], [6, 5, 3, 3, 2], [3, 3, 5, 4, 9], [3, 5, 3, 9, 0]])
    8
    """
    return max(calculate_scenic_score(trees, row, col) for col in range(len(trees[0])) for row in range(len(trees)))


def solve():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        trees = [list(map(int, line)) for line in puzzle_input.split('\n')]

        # Part 1
        result1 = count_trees_visible_from_outside(trees)
        print(f'{result1=}')

        # Part 2
        result2 = calculate_max_scenic_score(trees)
        print(f'{result2=}')


if __name__ == '__main__':
    doctest.testmod()
    solve()
