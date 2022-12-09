"""https://adventofcode.com/2022/day/5"""


import doctest


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def extract_stacks(puzzle_input):
    """
    >>> extract_stacks('    [D]\\n[N] [C]\\n[Z] [M] [P]\\n 1   2   3\\n\\nmove 1 from 2 to 1\\nmove 3 from 1 to 3\\nmove 2 from 2 to 1\\nmove 1 from 1 to 2')
    [['Z', 'N'], ['M', 'C', 'D'], ['P']]
    """
    # Take lines from first half
    stacks = puzzle_input.split('\n\n')[0].split('\n')
    # Pad lines to identical length
    stacks = list(map(lambda line: line.ljust(len(stacks[-1]), ' '), stacks))
    # Take vertical slices
    stacks = list(zip(*stacks))
    # Filter out non-stack lines
    stacks = list(filter(lambda line: line[-1].isnumeric(), stacks))
    # Reverse
    stacks = list(map(lambda stack: list(reversed(stack)), stacks))
    # Filter stacks for crates
    stacks = list(map(lambda stack: list(filter(lambda cell: not cell.isspace() and not cell.isnumeric(), stack)), stacks))
    return stacks


def move_line_to_move(move_line):
    """
    >>> move_line_to_move('move 1 from 2 to 1')
    {'how_many': 1, 'from': 2, 'to': 1}
    """
    split = move_line.split(' ')
    return {'how_many': int(split[1]), 'from': int(split[3]), 'to': int(split[5])}


def extract_moves(puzzle_input):
    """
    >>> extract_moves('''[D]\\n[N] [C]\\n[Z] [M] [P]\\n 1   2   3\\n\\nmove 1 from 2 to 1\\nmove 3 from 1 to 3\\nmove 2 from 2 to 1\\nmove 1 from 1 to 2''')
    [{'how_many': 1, 'from': 2, 'to': 1}, {'how_many': 3, 'from': 1, 'to': 3}, {'how_many': 2, 'from': 2, 'to': 1}, {'how_many': 1, 'from': 1, 'to': 2}]
    """
    move_lines = puzzle_input.split('\n\n')[1].split('\n')
    return list(map(move_line_to_move, move_lines))


def apply_move_one_by_one(stacks, move):
    """
    >>> apply_move_one_by_one([['Z', 'N'], ['M', 'C', 'D'], ['P']], {'how_many': 1, 'from': 2, 'to': 1})
    [['Z', 'N', 'D'], ['M', 'C'], ['P']]
    >>> apply_move_one_by_one([['Z', 'N'], ['M', 'C', 'D'], ['P']], {'how_many': 2, 'from': 2, 'to': 1})
    [['Z', 'N', 'D', 'C'], ['M'], ['P']]
    """
    from_index = move['from'] - 1
    to_index = move['to'] - 1
    for _ in range(move['how_many']):
        stacks[to_index].append(stacks[from_index].pop())
    return stacks


def apply_move_all_at_once(stacks, move):
    """
    >>> apply_move_all_at_once([['Z', 'N'], ['M', 'C', 'D'], ['P']], {'how_many': 1, 'from': 2, 'to': 1})
    [['Z', 'N', 'D'], ['M', 'C'], ['P']]
    >>> apply_move_all_at_once([['Z', 'N'], ['M', 'C', 'D'], ['P']], {'how_many': 2, 'from': 2, 'to': 1})
    [['Z', 'N', 'C', 'D'], ['M'], ['P']]
    """
    from_index = move['from'] - 1
    to_index = move['to'] - 1
    how_many = move['how_many']

    stacks[to_index] += stacks[from_index][-how_many:]
    stacks[from_index] = stacks[from_index][:-how_many]

    return stacks


def solve(apply_move_function):
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read()
        stacks = extract_stacks(puzzle_input)
        moves = extract_moves(puzzle_input)
        for move in moves:
            stacks = apply_move_function(stacks, move)
        print(''.join([l[-1] for l in stacks]))


def solve1():
    solve(apply_move_one_by_one)

def solve2():
    solve(apply_move_all_at_once)


if __name__ == '__main__':
    doctest.testmod()
    solve1()
    solve2()
