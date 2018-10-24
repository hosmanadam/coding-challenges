"""https://www.codewars.com/kata/convert-all-the-cases/train/python

RegEx:
- lookbehind: unnecessary due to non-overlapping nature of RegEx:
              (if previous match has ended, that's the starting point)
- capture: 1 or more letters, the first of which may be a capital letter
- lookahead: $ or _ or - or [A-Z]

Notes:
- doesn't deal with leading/trailing underscores
- doesn't deal with numbers (not in the requirements, probably because they're ambiguous as shit)
"""

import re

def change_case(identifier, targetCase):
  if targetCase not in ('camel', 'snake', 'kebab'): return None
  if ('_' in identifier) + ('-' in identifier) + (not identifier.islower()) > 1: return None
  words = [word.lower() for word in re.findall(r'([A-Za-z][a-z]*)(?=[A-Z]|\-|\_|$)', identifier)]
  if targetCase == 'camel':
    if len(words) < 2: return ''.join(words)
    return ''.join([words[0]] + [word[0].upper() + word[1:] for word in words[1:]])
  if targetCase == 'snake': return '_'.join(words)
  if targetCase == 'kebab': return '-'.join(words)

# TESTS
print(change_case("snakeCase", "snake")) # "snake_case", "camelCase to snake_case conversion should work")    
print(change_case("some-lisp-name", "camel")) # "someLispName", "kebab-case to camelCase conversion should work")    
print(change_case("map_to_all", "kebab")) # "map-to-all", "snake_case to kebab-case conversion should work")    
print(change_case("doHTMLRequest", "kebab")) # "do-h-t-m-l-request", "camelCase to kebab-case conversion should work")    
print(change_case("invalid-inPut_bad", "kebab")) # None, "mIx-ed_cAse input should be considered invalid")    
print(change_case("valid-input", "huh???")) # None, "Invalid target cases should be dealt with")    
print(change_case("", "camel")) # "", "An empty string should not be changed.")
