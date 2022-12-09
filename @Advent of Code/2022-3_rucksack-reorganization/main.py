"""https://adventofcode.com/2022/day/3"""


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'

ASCII_LETTERS = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'


def find_misaligned_item(rucksack):
    compartment_1 = rucksack[: len(rucksack)//2]
    compartment_2 = rucksack[len(rucksack)//2 :]

    for item in compartment_1:
        if item in compartment_2:
            return item


def get_priority(item):
    return ASCII_LETTERS.index(item) + 1


def solve1():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        rucksacks = puzzle_input.split('\n')
        misaligned_items = list(map(find_misaligned_item, rucksacks))
        priorities = list(map(get_priority, misaligned_items))
        priorities_total = sum(priorities)
        print(f'{priorities_total=}')


def find_common_item(rucksacks):
    for item in rucksacks[0]:
        if all([item in rucksack for rucksack in rucksacks[1:]]):
            return item


def solve2():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        rucksacks = puzzle_input.split('\n')
        badges = []
        for i in range(0, len(rucksacks), 3):
            badges += find_common_item(rucksacks[i:i+3])
        priorities = list(map(get_priority, badges))
        priorities_total = sum(priorities)
        print(f'{priorities_total=}')


if __name__ == '__main__':
    solve1()
    solve2()
