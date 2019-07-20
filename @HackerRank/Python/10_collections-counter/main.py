"""https://www.hackerrank.com/challenges/collections-counter/problem"""

from collections import Counter

input()
stock = Counter(map(int, input().split(' ')))

income = 0
for _ in range(int(input())):
    size, offer = map(int, input().split(' '))
    if stock.get(size):
        income += offer
        stock[size] -= 1

print(income)
