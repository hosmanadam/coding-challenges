"""https://www.codewars.com/kata/function-composition/train/python"""

def compose(f,g):
    return lambda *x: f(g(*x))
