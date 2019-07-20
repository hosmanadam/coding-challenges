"""https://www.hackerrank.com/challenges/alphabet-rangoli/problem"""

ABC = 'abcdefghijklmnopqrstuvwxyz'

def get_letter_chain(abc_first, abc_last):
    left_side = ABC[abc_last:abc_first:-1]
    right_side = ABC[abc_first:abc_last+1]
    return '-'.join(left_side + right_side)

def print_rangoli(size):
    width = (size - 1) * 4 + 1
    for i in list(range(size)) + list(range(size-2, -1, -1)):
        chain = get_letter_chain(size-i-1, size-1)
        print(chain.center(width, '-'))

if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)
