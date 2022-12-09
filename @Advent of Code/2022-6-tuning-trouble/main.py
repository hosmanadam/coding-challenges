"""https://adventofcode.com/2022/day/6"""

import doctest


INPUT_FILENAME = 'puzzle_input.txt'
# INPUT_FILENAME = 'puzzle_input_sample.txt'


def all_different(str):
    """
    >>> all_different('asdf')
    True
    >>> all_different('aasd')
    False
    """
    return len(set(str)) == len(str)


def find_marker_position(datastream_buffer, marker_length):
    for start_index in range(len(datastream_buffer) - marker_length):
        end_index = start_index + marker_length
        marker_position_candidate = datastream_buffer[start_index:end_index]
        if all_different(marker_position_candidate):
            return end_index


def find_packet_marker_position(datastream_buffer):
    """
    >>> find_packet_marker_position('bvwbjplbgvbhsrlpgdmjqwftvncz')
    5
    >>> find_packet_marker_position('nppdvjthqldpwncqszvftbrmjlhg')
    6
    >>> find_packet_marker_position('nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg')
    10
    >>> find_packet_marker_position('zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw')
    11
    """
    return find_marker_position(datastream_buffer, 4)


def find_message_marker_position(datastream_buffer):
    """
    >>> find_message_marker_position('mjqjpqmgbljsphdztnvjfqwrcgsmlb')
    19
    >>> find_message_marker_position('bvwbjplbgvbhsrlpgdmjqwftvncz')
    23
    >>> find_message_marker_position('nppdvjthqldpwncqszvftbrmjlhg')
    23
    >>> find_message_marker_position('nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg')
    29
    >>> find_message_marker_position('zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw')
    26
    """
    return find_marker_position(datastream_buffer, 14)


def solve():
    with open(INPUT_FILENAME, 'r') as file:
        puzzle_input = file.read().strip()

        # Part 1
        packet_marker_position = find_packet_marker_position(puzzle_input)
        print(f'{packet_marker_position=}')

        # Part 1
        message_marker_position = find_message_marker_position(puzzle_input)
        print(f'{message_marker_position=}')


if __name__ == '__main__':
    doctest.testmod()
    solve()
