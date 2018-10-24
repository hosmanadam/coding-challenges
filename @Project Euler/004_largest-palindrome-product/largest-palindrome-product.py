"""https://projecteuler.net/problem=4

A palindromic number reads the same both ways.
The largest palindrome made from the product of two 2-digit numbers is
9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
"""

"""v2 - My solution improved by stealing"""

palindrome = (0, 0, 0)
for x in range(999, 99, -1): # goes in reverse
  for y in range(999, 99, -1):
    if str(x*y) == str(x*y)[::-1]:
      palindrome = max(palindrome, (x*y, x, y)) # self-referencing stuff, I need to think more like this

print(f"The largest palindrome made from the product of two 3-digit numbers is {palindrome[0]}. It is the product of {palindrome[1]}*{palindrome[2]}.")


"""v1 - My original solution"""

# def is_palindrome(num):
#   string = str(num)
#   if string == string[::-1]:
#     return True
#   return False
#
# palindromes = set()
# for x in range(100, 1000):
#   for y in range(100, 1000):
#     if is_palindrome(x*y):
#       palindromes.add((x*y, x, y))
#
# result = max(palindromes)[0]
# print(f"The largest palindrome made from the product of two 3-digit numbers is {result}.\nIt is the product of {max(palindromes)[1]}*{max(palindromes)[2]}.")
