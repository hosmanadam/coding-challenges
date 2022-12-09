"""https://adventofcode.com/2022/day/4"""


import doctest


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def to_int_tuple_pair(range_pair_string):
    """
    >>> to_int_tuple_pair('2-66,4-82')
    [(2, 66), (4, 82)]
    """
    range_strings = range_pair_string.split(',') # ['2-66', '4-82']
    return [tuple(map(int, range.split('-'))) for range in range_strings] # [(2, 66), (4, 82)]


def is_one_fully_contained_in_other(range_pair):
    """
    >>> is_one_fully_contained_in_other([(2, 66), (4, 64)])
    True
    >>> is_one_fully_contained_in_other([(2, 66), (4, 68)])
    False
    """
    return (range_pair[0][0] <= range_pair[1][0] <= range_pair[1][1] <= range_pair[0][1]
         or range_pair[1][0] <= range_pair[0][0] <= range_pair[0][1] <= range_pair[1][1])


def is_overlapping(range_pair):
    """
    >>> is_overlapping([(2, 66), (4, 64)])
    True
    >>> is_overlapping([(2, 66), (4, 68)])
    True
    >>> is_overlapping([(2, 66), (66, 90)])
    True
    >>> is_overlapping([(2, 66), (67, 90)])
    False
    """
    return (range_pair[1][0] <= range_pair[0][0] <= range_pair[1][1]
         or range_pair[1][0] <= range_pair[0][1] <= range_pair[1][1]
         or range_pair[0][0] <= range_pair[1][0] <= range_pair[0][1]
         or range_pair[0][0] <= range_pair[1][1] <= range_pair[0][1])


def solve():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip() # '6-6,4-6\n2-6,4-8'
        range_pair_strings = puzzle_input.split('\n') # ['6-6,4-6', '2-6,4-8']
        range_pairs_processed = list(map(to_int_tuple_pair, range_pair_strings)) # [[(6, 6), (4, 6)], [(2, 6), (4, 8)]]

        # Part 1
        result1 = sum(map(is_one_fully_contained_in_other, range_pairs_processed))
        print(f'{result1=}')

        # Part 2
        result2 = sum(map(is_overlapping, range_pairs_processed))
        print(f'{result2=}')


if __name__ == '__main__':
    doctest.testmod()
    solve()
