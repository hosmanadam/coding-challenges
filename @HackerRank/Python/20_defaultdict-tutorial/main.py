"""https://www.hackerrank.com/challenges/defaultdict-tutorial/problem"""

from collections import defaultdict

n, m = map(int, input().split(' '))
words = defaultdict(list)
words['A'] = [input() for _ in range(n)]
words['B'] = [input() for _ in range(m)]

for b in words['B']:
    print(' '.join(str(i+1) for i, a in enumerate(words['A']) if a == b) or '-1')
