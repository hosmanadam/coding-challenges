"""https://www.codewars.com/kata/simple-pig-latin/train/python"""

import re

def pig_it(text):
  return re.sub(r'\w+', lambda x: x.group()[1:] + x.group()[0] + 'ay', text)

# def pig_it(text):
#   """Another CW solution, uses isalpha() built-in"""
#   lst = text.split()
#   return ' '.join( [word[1:] + word[:1] + 'ay' if word.isalpha() else word for word in lst])

# def pig_it(text):
#   """Top CW solution, performs the manipulation inside RegEx"""
#   return re.sub(r'([a-z])([a-z]*)', r'\2\1ay', text, flags=re.I)


# TESTS
print(pig_it('Pig latin is cool')) # igPay atinlay siay oolcay
print(pig_it('Hello world !'))     # elloHay orldway !