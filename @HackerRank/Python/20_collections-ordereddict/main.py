"""https://www.hackerrank.com/challenges/py-collections-ordereddict/problem"""

from collections import OrderedDict

sales = OrderedDict()

for _ in range(int(input())):
    line = input().split()
    key, val = ' '.join(line[:-1]), int(line[-1])
    sales[key] = sales.get(key) + val if sales.get(key) else val

for key in sales.keys():
    print(key, sales[key])
