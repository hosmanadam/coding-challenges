"""https://www.codewars.com/kata/weight-for-weight/train/python"""

def order_weight(strng):
  lst = strng.split(' ')
  lst = sorted(lst, key=lambda x: x.lower())
  lst = sorted(lst, key=lambda x: sum(int(char) for char in x))
  return ' '.join(lst)

# TESTS
print(order_weight("103 123 4444 99 2000")) # "2000 103 123 4444 99"
print(order_weight("2000 10003 1234000 44444444 9999 11 11 22 123")) # "11 11 2000 10003 22 123 1234000 44444444 9999"
