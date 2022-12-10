"""https://adventofcode.com/2022/day/1"""

INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def solve():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read()

        # Part 1
        elves_as_strings = puzzle_input.split('\n\n')
        elves_as_string_lists = [elf_string.split('\n') for elf_string in elves_as_strings]
        elves_as_int_lists = [list(map(int, elf_string_list)) for elf_string_list in elves_as_string_lists]
        elves_as_summed_ints = list(map(sum, elves_as_int_lists))
        most_calories_carried = max(elves_as_summed_ints)
        print(f'{most_calories_carried=}')

        # Part 2
        top_three = sorted(elves_as_summed_ints)[-3:]
        top_three_total = sum(top_three)
        print(f'{top_three_total=}')


if __name__ == '__main__':
    solve()
