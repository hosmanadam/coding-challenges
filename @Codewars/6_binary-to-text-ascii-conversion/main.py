"""https://www.codewars.com/kata/binary-to-text-ascii-conversion/train/python"""


def binary_to_string(binary):
    bits = [binary[i:i+8] for i in range(0, len(binary), 8)]
    return ''.join(chr(int(bit, 2)) for bit in bits)
