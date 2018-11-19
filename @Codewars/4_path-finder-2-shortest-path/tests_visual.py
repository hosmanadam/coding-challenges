from random import choice

import main


def generate_maze(width, height):
    first = lambda W: '.' + ''.join([choice('..W') for i in range(W-1)])
    body  = lambda W:       ''.join([choice('..W') for i in range(W)])
    last  = lambda W:       ''.join([choice('..W') for i in range(W-1)]) + '.'
    if height < 1 or width < 1: return ''
    if height == 1: return "\n".join([first(width-1) + '.']) if height > 1 else first(width-1)
    return "\n".join([first(width)] + [body(width) for i in range(height-2)] + [last(width)])


def main():
    maze = generate_maze(30, 30)
    print(maze)
    print(main.path_finder(maze))


if __name__ == '__main__':
    main()
