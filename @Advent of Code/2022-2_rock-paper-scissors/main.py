"""https://adventofcode.com/2022/day/2"""


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def solve1():
    moves_to_points = {
        "A X": 1 + 3, # rock rock
        "A Y": 2 + 6, # rock paper
        "A Z": 3 + 0, # rock scissors
        "B X": 1 + 0, # paper rock
        "B Y": 2 + 3, # paper paper
        "B Z": 3 + 6, # paper scissors
        "C X": 1 + 6, # scissors rock
        "C Y": 2 + 0, # scissors paper
        "C Z": 3 + 3, # scissors scissors
    }

    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        rounds = puzzle_input.split('\n')
        points = [moves_to_points[round] for round in rounds]
        points_total = sum(points)
        print(f'{points_total=}')


def solve2():
    moves_to_points = {
        "A X": 3 + 0, # rock lose->scissors
        "A Y": 1 + 3, # rock draw->rock
        "A Z": 2 + 6, # rock win->paper
        "B X": 1 + 0, # paper lose->rock
        "B Y": 2 + 3, # paper draw->paper
        "B Z": 3 + 6, # paper win->scissors
        "C X": 2 + 0, # scissors lose->paper
        "C Y": 3 + 3, # scissors draw->scissors
        "C Z": 1 + 6, # scissors win->rock
    }

    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()
        rounds = puzzle_input.split('\n')
        points = [moves_to_points[round] for round in rounds]
        points_total = sum(points)
        print(f'{points_total=}')


if __name__ == '__main__':
    solve1()
    solve2()
