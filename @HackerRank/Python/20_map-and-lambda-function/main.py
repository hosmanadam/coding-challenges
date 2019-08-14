"""https://www.hackerrank.com/challenges/map-and-lambda-expression/problem"""

cube = lambda x: x**3


def fibonacci(n):
    result = [0, 1]
    while len(result) < n:
        result.append(sum(result[-2:]))
    return result[:n]


if __name__ == '__main__':
    n = int(input())
    print(list(map(cube, fibonacci(n))))
