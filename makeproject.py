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


import os
import re

from templates import UNITTEST_TEMPLATE, FUNCTION_TEMPLATE


def make_project(num, name, url):
    os.chdir(os.sys.path[0])  # set CWD (avoid creating the files somewhere else)
    name = kebabize(name)
    dirname = f"→{num}_{name}"
    os.makedirs(dirname)
    os.chdir(dirname)
    with open('main.py', 'w') as file:
        file.write(f'"""{url}"""\n\n' + FUNCTION_TEMPLATE)
    with open('tests.py', 'w') as file:
        file.write(UNITTEST_TEMPLATE)


def kebabize(name):
    name = re.sub(r'\s+', '-', name)
    name = name.strip('-').lower()
    return re.sub(r'[^a-z\d-]+', '', name)


def main():
    num = input('Num:  ')
    name = input('Name: ')
    url = input('URL:  ')
    make_project(num, name, url)


if __name__ == '__main__':
    main()
