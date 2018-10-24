"""https://www.codewars.com/kata/541c8630095125aba6000c00/train/python"""

"""v1"""
def digital_root(n):
  if len(str(n)) == 1:
    return n
  return digital_root(sum([int(char) for char in str(n)]))

"""Top CW solution - uses map() instead of listcomp"""
# def digital_root(n):
#   return n if n < 10 else digital_root(sum(map(int,str(n))))
