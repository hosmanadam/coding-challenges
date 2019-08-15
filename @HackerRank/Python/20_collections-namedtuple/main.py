"""https://www.hackerrank.com/challenges/py-collections-namedtuple/problem"""

from collections import namedtuple
import re

rows = int(input())
Row = namedtuple('Row', input())
print(sum(int(Row(*re.split('\s+', input())).MARKS) for _ in range(rows)) / rows)
