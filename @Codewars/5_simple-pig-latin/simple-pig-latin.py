"""https://www.codewars.com/kata/simple-pig-latin/train/python"""

"""v1"""
import re
def pig_it(text):
  return re.sub(r'\w+', lambda x: x.group()[1:] + x.group()[0] + 'ay', text)

"""Another CW solution - uses isalpha() built-in"""
# def pig_it(text):
#   lst = text.split()
#   return ' '.join( [word[1:] + word[:1] + 'ay' if word.isalpha() else word for word in lst])

"""Top CW solution - performs the manipulation inside RegEx"""
# def pig_it(text):
#   return re.sub(r'([a-z])([a-z]*)', r'\2\1ay', text, flags=re.I)


# TESTS
print(pig_it('Pig latin is cool')) # igPay atinlay siay oolcay
print(pig_it('Hello world !'))     # elloHay orldway !