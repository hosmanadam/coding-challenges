"""https://www.codewars.com/kata/convert-pascalcase-string-into-snake-case/train/python"""

"""v2 - Just for practice"""
# def to_underscore(string):
#   return ''.join([f'_{x.lower()}' if x.isupper() else x for x in str(string)]).strip('_')

"""v1"""
def to_underscore(string):
  string = str(string)
  for char in string:
    if char.isupper():
      string = string.replace(char, f'_{char.lower()}')
  return string.strip('_')


# TESTS
print(to_underscore('TestController'))
