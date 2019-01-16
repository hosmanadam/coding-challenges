"""https://www.codewars.com/kata/string-%3E-n-iterations-%3E-string/train/python"""

import string
import random


"""v2 - Optimized

- recognizes that:
    - shuffling returns string to original order after `c` cycles,
      so if we know `c`, we only need to perform `n % c` operations
    - cycle number is the same for each odd int `n` as `n+1`
    - this cycle number is known as the "multiplicative order":
        - https://oeis.org/A002326
        - http://mathforum.org/library/drmath/view/55921.html
- process:
    - made `generate_repeating_pattern()` to generate sequence of cycles for each int
    - Googled math rules for the sequence
    - made `get_multiplicative_order()` based on these rules
      (the smallest power to which `2` must be raised to leave a remainder of `1` when divided by `m`)
"""
def get_multiplicative_order(m):
    if m in (0, 1, 2):
        return 1
    if m % 2 == 0:
        m -= 1
    n = 1
    while True:
        if (2**n) % m == 1:
            return n
        n += 1


def jumbled_string(s, n):
    cycles = get_multiplicative_order(len(s))
    for i in range(n % cycles):
        s = s[0::2] + s[1::2]
    return s


"""v1 - Unoptimized: works, but times out on full tests"""
# def jumbled_string(s, n):
#     char_list = list(s)
#     for i in range(n):
#         char_list = char_list[0::2] + char_list[1::2]
#     return ''.join(char_list)


"""Top CW solution - stays with core logic w/o bothering with more maths than necessary"""
# def jumbled_string(s, n):
#     iterations = [s]
#
#     while True:
#         s = s[::2] + s[1::2]
#         if s == iterations[0]: break
#         iterations.append(s)
#
#     return iterations[n % len(iterations)]


"""Research"""
def generate_repeating_pattern():
    for length in range(2, 100, 2):
        original = ''.join(random.choice(string.ascii_letters) for i in range(length))
        cycles = 1
        while True:
            jumbled = jumbled_string(original, cycles)
            if original == jumbled:
                multiplicative_order = get_multiplicative_order(len(original))
                # print(f'{i}, ', end='')
                print(f'Len: {length: <3} Cycles: {cycles: <3} ({multiplicative_order}?)')
                break
            cycles += 1


if __name__ == '__main__':
    generate_repeating_pattern()
