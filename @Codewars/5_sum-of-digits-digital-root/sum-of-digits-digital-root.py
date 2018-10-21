"""https://www.codewars.com/kata/541c8630095125aba6000c00/train/python"""

def digital_root(n):
  """My solution"""
  if len(str(n)) == 1:
    return n
  return digital_root(sum([int(char) for char in str(n)]))

# def digital_root(n):
#   """Top CW solution, uses map() instead of listcomp"""
#   return n if n < 10 else digital_root(sum(map(int,str(n))))
