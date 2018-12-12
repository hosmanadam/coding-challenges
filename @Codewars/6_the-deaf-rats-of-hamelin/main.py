"""https://www.codewars.com/kata/the-deaf-rats-of-hamelin/train/python"""


def separate_rats(queue):
    return [queue[i:i + 2] for i in range(0, len(queue), 2)]

def count_deaf_rats(town):
    left, right = town.replace(' ', '').split('P')
    return separate_rats(left).count('O~') + separate_rats(right).count('~O')
