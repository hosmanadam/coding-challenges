"""https://adventofcode.com/2022/day/7"""


import doctest


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'

SMALL_FILE_SIZE_LIMIT = 100000
DISK_CAPACITY = 70000000
SPACE_NEEDED_FOR_UPDATE = 30000000


def get_sublist(root, indexes):
    """
    :param root:     The main list
    :param indexes:  The indexes used to address the sublist
    :return:         Sublist of the main `root` list, as addressed by `indexes`

    >>> get_sublist([[[584], 29116, 2557, 62596], 14848514, 8504156, [4060174, 8033020, 5626152, 7214296]], [0, 0])
    [584]
    """
    lst = root
    for i in indexes:
        lst = lst[i]
    return lst


def parse_to_composite_number_list(puzzle_input):
    """
    Parses the puzzle input into a composite data structure, keeping only the minimum information we need:
    - Files become numbers based on their sizes (names are ignored)
    - Directories become lists (of other lists/numbers)

    We need to keep a reference to the directory we're at, so we can navigate in and out of it.
    Let's call it PWL ("Present Working List")
    We can't use the object reference because we could only navigate in (no reference to the parent).
    We need to do it by address, so we can navigate out too.
    The depth will change dynamically, so we can't have the address as a fixed number of running variables for the indexes.
    We need to have a dynamic address that will get longer/shorter as we navigate.
    We can build it as a list of numbers and always find the PWL from that.

    We'll process input lines one by one.
    There's a total of 6 types of different lines, and therefore 6 scenarios for handling them.
    The 6 scenarios are denoted A-F on the example puzzle input below:

    $ cd /          # A: Ignore (this is root)
    $ ls            # B: Ignore (always comes after 'cd')
    dir a           # C: Ignore (we'll add it and go in on 'cd')
    14848514 b.txt  # D: Append to PWL
    8504156 c.dat   # D
    dir d           # C
    $ cd a          # E: Append new list to PWL, append `len(pwl)-1` to indexes, re-evaluate PWL
    $ ls            # B
    dir e           # C
    29116 f         # D
    2557 g          # D
    62596 h.lst     # D
    $ cd e          # E
    $ ls            # B
    584 i           # D
    $ cd ..         # F: Pop last index, re-evaluate PWL
    $ cd ..         # F
    $ cd d          # E
    $ ls            # B
    4060174 j       # D
    8033020 d.log   # D
    5626152 d.ext   # D
    7214296 k       # D

    >>> parse_to_composite_number_list('$ cd /\\n$ ls\\ndir a\\n14848514 b.txt\\n8504156 c.dat\\ndir d\\n$ cd a\\n$ ls\\ndir e\\n29116 f\\n2557 g\\n62596 h.lst\\n$ cd e\\n$ ls\\n584 i\\n$ cd ..\\n$ cd ..\\n$ cd d\\n$ ls\\n4060174 j\\n8033020 d.log\\n5626152 d.ext\\n7214296 k')
    [14848514, 8504156, [29116, 2557, 62596, [584]], [4060174, 8033020, 5626152, 7214296]]
    """
    lines = puzzle_input.split('\n')
    root = []
    indexes = []
    pwl = root

    for line in lines:
        if line == '$ cd /':
            continue
        elif line == '$ ls':
            continue
        elif line[:4] == 'dir ':
            continue
        elif line[0].isnumeric():
            num = int(line.split(' ')[0])
            pwl.append(num)
        elif line == '$ cd ..':
            indexes.pop()
            pwl = get_sublist(root, indexes)
        elif line[:4] == '$ cd':
            pwl.append([])
            index_of_new_list = len(pwl) - 1
            indexes.append(index_of_new_list)
            pwl = get_sublist(root, indexes)

    return root


def sum_composite_number_list(tree, subtotal_collector=None):
    """
    :param tree:                The composite number list to be summed
    :param subtotal_collector:  Return parameter, list of all subtotals encountered during the calculation
    :return:                    Tuple of total sum and list of all subtotals encountered during the calculation

    >>> sum_composite_number_list([14848514, 8504156, [29116, 2557, 62596, [584]], [4060174, 8033020, 5626152, 7214296]])
    (48381165, [584, 94853, 24933642, 48381165])
    """
    if subtotal_collector is None:
        subtotal_collector = []

    total = 0
    for item in tree:
        if type(item) == int:
            total += item
        else:
            total += sum_composite_number_list(item, subtotal_collector)[0]

    subtotal_collector.append(total)
    return total, subtotal_collector


def solve():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        tree = parse_to_composite_number_list(puzzle_input)

        # Part 1
        _, all_dir_sizes = sum_composite_number_list(tree)
        small_dirs = filter(lambda size: size <= SMALL_FILE_SIZE_LIMIT, all_dir_sizes)
        result1 = sum(small_dirs)
        print(f'{result1=}')

        # Part 2
        space_used, all_dir_sizes = sum_composite_number_list(tree)
        free_space = DISK_CAPACITY - space_used
        extra_space_needed_for_update = SPACE_NEEDED_FOR_UPDATE - free_space
        large_dirs = filter(lambda size: size >= extra_space_needed_for_update, all_dir_sizes)
        result2 = min(large_dirs)
        print(f'{result2=}')


if __name__ == '__main__':
    doctest.testmod()
    solve()
