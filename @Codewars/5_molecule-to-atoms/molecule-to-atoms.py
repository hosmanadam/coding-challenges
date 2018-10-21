"""https://www.codewars.com/kata/molecule-to-atoms/train/python

Whole process on 'K4[ON(SO3)2]2':
0) Initial                                   →                         #         'K4[ON(SO3)2]2'
1) Expand non-braced:                   'K4' → 'KKKK'                  # result: 'KKKK[ON(SOOO)2]2'
2) Expand innermost_braced:        '(SOOO)2' → 'SOOOSOOO'              # result: 'KKKK[ONSOOOSOOO]2'
3) Expand innermost_braced:  '[ONSOOOSOOO]2' → 'ONSOOOSOOOONSOOOSOOO'  # result: 'KKKKONSOOOSOOOONSOOOSOOO'
"""

import re

atom = r'(?P<atom>[A-Z][a-z]?)'
non_braced = atom + r'(?P<num>\d+)'
innermost_braced = r'[\(\[\{](?P<atoms>(?:[A-Z][a-z]?)+)[\)\]\}](?P<num>\d+)'

def parse_molecule(formula):
  formula = re.sub(non_braced, lambda x: x.group('atom') * int(x.group('num')), formula)
  while re.search(innermost_braced, formula):
    formula = re.sub(innermost_braced, lambda x: x.group('atoms') * int(x.group('num')), formula)
  formula = re.findall(atom, formula)
  return {atom:formula.count(atom) for atom in formula}

# TESTS
print(parse_molecule('Ka2O')) # {'Ka': 2, 'O' : 1}
print(parse_molecule('Mg(OH)2')) # {'Mg': 1, 'O' : 2, 'H': 2}
print(parse_molecule('K4[ON(SO3)2]2')) # {'K': 4,  'O': 14,  'N': 2,  'S': 4}
