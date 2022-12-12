"""https://adventofcode.com/2022/day/9"""

import doctest
from itertools import chain

INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def parse_to_vector(line):
    """
    Turns an input line into a vector representing the mathematical difference between one position and the next.
    These are NOT matrix indexes, but traditional 2D coordinates: not (row, col) but (x, y)

    >>> parse_to_vector('R 34') # Move right: x++
    (34, 0)
    >>> parse_to_vector('L 34') # Move left: x--
    (-34, 0)
    >>> parse_to_vector('U 34') # Move up: y++
    (0, 34)
    >>> parse_to_vector('D 34') # Move down: y--
    (0, -34)
    """
    direction = line[0]
    distance = int(line[2:])
    match direction:
        case 'R': return distance, 0
        case 'L': return -distance, 0
        case 'U': return 0, distance
        case 'D': return 0, -distance


def truncate_number(number, maximum):
    """
    >>> truncate_number(-2, 1)
    -1
    >>> truncate_number(-1, 1)
    -1
    >>> truncate_number(0, 1)
    0
    >>> truncate_number(1, 1)
    1
    >>> truncate_number(2, 1)
    1
    """
    return min(abs(number), maximum) * (1 if number >= 0 else -1)


def truncate_vector(vector):
    """
    >>> truncate_vector((1, 2))
    (1, 1)
    >>> truncate_vector((1, -2))
    (1, -1)
    """
    return tuple(truncate_number(number, 1) for number in vector)


def split_to_moves(vector):
    """
    >>> split_to_moves((2, 0))
    [(1, 0), (1, 0)]
    >>> split_to_moves((0, 0))
    []
    """
    n_moves = max(map(abs, vector))
    move = truncate_vector(vector)
    return n_moves * [move]


def calculate_next_position(current_position, vector):
    """
    >>> calculate_next_position((5, 5), (0, 10))
    (5, 15)
    >>> calculate_next_position((5, 5), (0, -10))
    (5, -5)
    >>> calculate_next_position((5, 5), (10, 0))
    (15, 5)
    >>> calculate_next_position((5, 5), (-10, 0))
    (-5, 5)
    """
    return current_position[0] + vector[0], current_position[1] + vector[1]


def calculate_difference(start, end):
    """
    >>> calculate_difference((5, 5), (7, 4))
    (2, -1)
    """
    return end[0] - start[0], end[1] - start[1]


def should_move(position_difference):
    """
    >>> should_move((1, 1))
    False
    >>> should_move((-1, -1))
    False
    >>> should_move((1, 2))
    True
    >>> should_move((-1, -2))
    True
    """
    return any([abs(difference_on_axis) > 1 for difference_on_axis in position_difference])


def follow_head(tail, head):
    """
    >>> follow_head((5, 5), (5, 5)) # Same position
    (5, 5)
    >>> follow_head((5, 5), (6, 6)) # Close enough
    (5, 5)
    >>> follow_head((5, 5), (7, 5)) # Pulled on one axis
    (6, 5)
    >>> follow_head((5, 5), (7, 6)) # Pulled on one axis, misaligned on both
    (6, 6)
    """
    difference = calculate_difference(tail, head)
    if should_move(difference):
        return calculate_next_position(tail, truncate_vector(difference))
    else:
        return tail


def solve():
    """
    Since there's no info about the size of the playing area, we'll assume it to be infinite.
    There's no need to represent this area using a data structure: we're only interested in the coordinates at any given time.
    """
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        vectors = map(parse_to_vector, puzzle_input.split('\n'))
        moves = list(chain(*map(split_to_moves, vectors)))

        for number_of_knots in (2, 10):
            tail_index = number_of_knots - 1
            knots = number_of_knots * [(0, 0)]
            tail_visited = {knots[tail_index]}
            for move in moves:
                knots[0] = calculate_next_position(knots[0], move)
                for i_leader in range(number_of_knots - 1):
                    i_follower = i_leader + 1
                    knots[i_follower] = follow_head(knots[i_follower], knots[i_leader])
                tail_visited.add(knots[tail_index])

            result = len(tail_visited)
            print(f'{number_of_knots=} → {result=}')


if __name__ == '__main__':
    doctest.testmod()
    solve()
