"""https://www.codewars.com/kata/connect-four-1/train/python"""


def letter_to_column_index(letter):
    return 'ABCDEFG'.index(letter.upper())


def rotate_90(board):
    return zip(*board[::-1])


def is_solved(board):
    """Return winning color if board is won, else `None`"""
    # Rows
    for row in board:
        for start in range(4):
            if row[start] and row[start] == row[start+1] == row[start+2] == row[start+3]:
                return row[start]
    # Columns
    for col in rotate_90(board):
        for start in range(3):
            if col[start] and col[start] == col[start+1] == col[start+2] == col[start+3]:
                return col[start]
    # Upper left - lower right diagonals
    for row_start_index in range(3):
        for column_start_index in range(4):
            if board[row_start_index][column_start_index] and board[row_start_index][column_start_index] == board[row_start_index+1][column_start_index+1] == board[row_start_index+2][column_start_index+2] == board[row_start_index+3][column_start_index+3]:
                return board[row_start_index][column_start_index]
    # Lower left - upper right diagonals
    for row_start_index in range(3, 6):
        for column_start_index in range(4):
            if board[row_start_index][column_start_index] and board[row_start_index][column_start_index] == board[row_start_index-1][column_start_index+1] == board[row_start_index-2][column_start_index+2] == board[row_start_index-3][column_start_index+3]:
                return board[row_start_index][column_start_index]


def next_available_row_index(board, column_index):
    for row_index in range(5, -1, -1):
        if not board[row_index][column_index]:
            return row_index


def make_move(move, board):
    column_index = letter_to_column_index(move[0])
    row_index = next_available_row_index(board, column_index)
    board[row_index][column_index] = move[2:]
    return board


def who_is_winner(moves):
    board = [[None] * 7 for i in range(6)]
    for move in moves:
        board = make_move(move, board)
        result = is_solved(board)
        if result:
            return result
    return 'Draw'
