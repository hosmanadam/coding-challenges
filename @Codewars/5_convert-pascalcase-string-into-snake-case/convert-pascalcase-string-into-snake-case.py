"""https://www.codewars.com/kata/convert-pascalcase-string-into-snake-case/train/python"""

# def to_underscore(string):
#   """v2 - Just for practice"""
#   return ''.join([f'_{x.lower()}' if x.isupper() else x for x in str(string)]).strip('_')

def to_underscore(string):
  """v1"""
  string = str(string)
  for char in string:
    if char.isupper():
      string = string.replace(char, f'_{char.lower()}')
  return string.strip('_')


# TESTS
print(to_underscore('TestController'))
