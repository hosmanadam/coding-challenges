"""https://www.hackerrank.com/challenges/word-order/problem"""

from collections import Counter

counter = Counter(input() for _ in range(int(input())))
print(len(counter))
print(*counter.values())
