"""https://www.codewars.com/kata/regex-password-validation/train/python"""

# """v3 - Broken up yet another way"""
# from re import compile, VERBOSE
# regex = compile('''
#                 ^
#                 (?=.*[a-z])
#                 (?=.*[A-Z])
#                 (?=.*[0-9])
#                 ([a-zA-Z0-9]{6,})
#                 $
#                 ''', VERBOSE)

# """v2 - Broken into components"""
# regex = (r'^'
#          r'(?=.*[a-z])'
#          r'(?=.*[A-Z])'
#          r'(?=.*[0-9])'
#          r'([a-zA-Z0-9]{6,})'
#          r'$')

"""v1 - Short but harder to read"""
regex = r'^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])([a-zA-Z0-9]{6,})$'


# TESTS
from re import search
print(bool(search(regex, 'fjd3IR9'))) # True
print(bool(search(regex, 'ghdfj32'))) # False
print(bool(search(regex, 'DSJKHD23'))) # False
print(bool(search(regex, 'dsF43'))) # False
print(bool(search(regex, '4fdg5Fj3'))) # True
print(bool(search(regex, 'DHSJdhjsU'))) # False
print(bool(search(regex, 'fjd3IR9.;'))) # False
print(bool(search(regex, 'fjd3  IR9'))) # False
print(bool(search(regex, 'djI38D55'))) # True
print(bool(search(regex, 'a2.d412'))) # False
print(bool(search(regex, 'JHD5FJ53'))) # False
print(bool(search(regex, '!fdjn345'))) # False
print(bool(search(regex, 'jfkdfj3j'))) # False
print(bool(search(regex, '123'))) # False
print(bool(search(regex, 'abc'))) # False
print(bool(search(regex, '123abcABC'))) # True
print(bool(search(regex, 'ABC123abc'))) # True
print(bool(search(regex, 'Password123'))) # True
