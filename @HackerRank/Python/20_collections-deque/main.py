"""https://www.hackerrank.com/challenges/py-collections-deque/problem"""

from collections import deque

d = deque()
for _ in range(int(input())):
    operation = input().split()
    method = operation[0]
    argument = operation[1] if len(operation) > 1 else ''
    exec(f"d.{method}({argument})")
print(*d)

