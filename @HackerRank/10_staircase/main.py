"""https://www.hackerrank.com/challenges/staircase/problem"""

"""v2 - Readable"""
def staircase(n):
    for i in range(n):
        stair = '#' * (i+1)
        padding = ' ' * (n-i-1)
        print(padding, stair, sep='')


"""v1 - Cool"""
# def staircase(n):
#     print(*[f"{'#'*(i+1):>{n}}" for i in range(n)], sep='\n')
