"""Script to automate folder & file creation for challenges

- example:
  $ python3 makeproject.py
  Num:  33
  Name: Kickass Fibonacci Sequence #5!
- creates:
  './→33_kickass-fibonacci-sequence-5/kickass-fibonacci-sequence-5.py'
"""

# TODO: take URL as input to...
# - extract challenge type (Codewars / Project Euler / other)
# - scrape number & title from page

import os

def make_project(num, name):
  os.chdir(os.sys.path[0])  # set CWD (avoid creating the files somewhere else)
  name = name.strip().lower().replace(' ', '-')
  for char in set(name):
    if char not in 'abcdefghijklmnopqrstuvwxyz0123456789-':
      name = name.replace(char, '')
  dirname = f"→{num}_{name}"
  filename = f"{name}.py"
  os.makedirs(dirname)
  os.chdir(dirname)
  with open(filename, 'w') as file:
    file.write('\"\"\"URL\"\"\"\n\ndef func():\n  pass\n\n# TESTS\n')


def main():
  num = input('Num:  ')
  name = input('Name: ')
  make_project(num, name)

if __name__ == '__main__':
  main()
