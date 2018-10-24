"""https://www.codewars.com/kata/string-incrementer/train/python"""

import re

"""v1"""
def increment_string(strng):
  word = re.search(r'(?<=^)(.*\D)(?=\d*$)', strng)
  seq = re.search(r'(\d+)(?=$)', strng)
  if word and seq: return word.group() + str(int(seq.group())+1).zfill(len(seq.group()))
  if seq: return str(int(seq.group())+1).zfill(len(seq.group()))
  if word: return word.group() + '1'
  return '1'

"""Top CW solution - doesn't use RegEx if it doesn't have to"""
# def increment_string(strng):
#   head = strng.rstrip('0123456789')
#   tail = strng[len(head):]
#   if tail == "": return strng+"1"
#   return head + str(int(tail) + 1).zfill(len(tail))


# TESTS
print(increment_string("foo")) # "foo1"
print(increment_string("foobar001")) # "foobar002"
print(increment_string("foobar1")) # "foobar2"
print(increment_string("foobar00")) # "foobar01"
print(increment_string("foobar99")) # "foobar100"
print(increment_string("foobar099")) # "foobar100"
print(increment_string("")) # "1"
print(increment_string("1")) # "2"
