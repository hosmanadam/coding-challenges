"""https://www.codewars.com/kata/connect-four-1/train/python"""

SHAPES = [
    {'row_start_index_range': (0, 3), 'col_start_index_range': (0, 7), 'row_step': 1, 'col_step': 0},  # Column
    {'row_start_index_range': (0, 6), 'col_start_index_range': (0, 4), 'row_step': 0, 'col_step': 1},  # Row
    {'row_start_index_range': (0, 3), 'col_start_index_range': (0, 4), 'row_step': 1, 'col_step': 1},  # UpL-LoR diagonal
    {'row_start_index_range': (0, 3), 'col_start_index_range': (3, 7), 'row_step': 1, 'col_step': -1}  # UpR-LoL diagonal
]


def is_solved(board):
    for shape in SHAPES:
        col_step, row_step = shape['col_step'], shape['row_step']
        for row_start_index in range(*shape['row_start_index_range']):
            for col_start_index in range(*shape['col_start_index_range']):
                four_pieces = [board[row_start_index + row_step * i][col_start_index + col_step * i] for i in range(4)]
                color = four_pieces[0]
                if color and all(color == piece for piece in four_pieces):
                    return color


def letter_to_column_index(letter):
    return 'ABCDEFG'.index(letter.upper())


def next_available_row_index(board, column_index):
    for row_index in range(5, -1, -1):
        if not board[row_index][column_index]:
            return row_index


def make_move(move, board):
    letter, color = move.split('_')
    column_index = letter_to_column_index(letter)
    row_index = next_available_row_index(board, column_index)
    board[row_index][column_index] = color
    return board


def who_is_winner(moves):
    board = [[None] * 7 for i in range(6)]
    for move in moves:
        board = make_move(move, board)
        winning_color = is_solved(board)
        if winning_color:
            return winning_color
    return 'Draw'
