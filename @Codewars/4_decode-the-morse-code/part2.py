"""https://www.codewars.com/kata/decode-the-morse-code-advanced/train/python"""

import re


"""v2 - With RegEx"""
def find_sampling_rate(bits):
    for i in range(1, len(bits)+1):
        for bit in '01':
            if re.search(f"[^{bit}][{bit}]{{{i}}}[^{bit}]", bits):
                return i


"""v1 - Plain old logic"""
# def find_sampling_rate(bits):
#     shortest = len(bits)
#     current = ''
#     for i in range(len(bits)):
#         if current == '' or bits[i] == current[-1]:
#             current += bits[i]
#         else:
#             if len(current) < shortest:
#                 shortest = len(current)
#             current = bits[i]
#     return shortest


"""Top CW solution - shorter, but more readable"""
# def find_sampling_rate(bits):
#     return min(len(m) for m in re.findall(r'1+|0+', bits))


def decodeBits(bits):
    bits = bits.strip('0')
    sampling_rate = find_sampling_rate(bits)
    bits = bits[::sampling_rate]
    bit_to_morse = [('0000000', '   '),
                    ('000', ' '),
                    ('111', '-'),
                    ('0', ''),
                    ('1', '.')]
    for pair in bit_to_morse:
        bits = bits.replace(pair[0], pair[1])
    return bits
