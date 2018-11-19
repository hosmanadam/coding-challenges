"""Script to automate folder & file creation for challenges

Example:
  - $ python3 makeproject.py
    Num:  33
    Name: Kickass Fibonacci Sequence #5!
    URL:  http://not-important-in-this-example.com
  - creates `./→33_kickass-fibonacci-sequence-5/main.py`
            `./→33_kickass-fibonacci-sequence-5/tests.py`
"""


# TODO: take URL as sole input and scrape for other data (challenge type, number, title, code, tests)
# TODO: open folder in Finder / file in IDE
# TODO: place project in proper challenge folder
# TODO: automate translation of Codewars tests into Python unit tests
# TEST_DICTIONARY = {'test': 'self',
#                    'assert_equals': 'assertEqual'}
# TODO: use RegEx for char swapping
# TODO: collapse multiple whitespaces into one


import os


UNITTEST_TEMPLATE = '''import unittest

import main


class SampleTests(unittest.TestCase):

  def test1(self):
    pass # TODO: write unit tests


if __name__ == '__main__':
  unittest.main(verbosity=2)
'''


FUNCTION_TEMPLATE = '''def foo():
  pass # TODO: implement
'''


def make_project(num, name, url):
  os.chdir(os.sys.path[0])  # set CWD (avoid creating the files somewhere else)
  name = name.strip().lower().replace(' ', '-')
  for char in set(name):
    if char not in 'abcdefghijklmnopqrstuvwxyz0123456789-':
      name = name.replace(char, '')
  dirname = f"→{num}_{name}"
  os.makedirs(dirname)
  os.chdir(dirname)
  with open('main.py', 'w') as file:
    file.write(f'"""{url}"""\n\n' + FUNCTION_TEMPLATE)
  with open('tests.py', 'w') as file:
    file.write(UNITTEST_TEMPLATE)


def main():
  num = input('Num:  ')
  name = input('Name: ')
  url = input('URL:  ')
  make_project(num, name, url)

if __name__ == '__main__':
  main()
