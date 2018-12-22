"""https://www.codewars.com/kata/rot13-1/train/python"""


"""v3 - More novel approach, but needs comment to explain what it does"""
# def rot13(message):
#     shifter = dict(zip('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ',
#                        'nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM'))  # shifted 13 to the right
#     return ''.join(shifter[char] if char in shifter else char for char in message)


"""v2 - No duplication, but harder to understand"""
# import string
#
# def rot13(message):
#     result = []
#     for char in message:
#         for alphabet in (string.ascii_lowercase, string.ascii_uppercase):
#             if char in alphabet:
#                 result.append(alphabet[alphabet.index(char)-13])
#                 break
#         result.append(char)
#     return ''.join(result)


"""v1 - Plain logic with some duplication"""
import string

def rot13(message):
    result = []
    for char in message:
        if char in string.ascii_lowercase:
            result.append(string.ascii_lowercase[string.ascii_lowercase.index(char)-13])
        elif char in string.ascii_uppercase:
            result.append(string.ascii_uppercase[string.ascii_uppercase.index(char)-13])
        else:
            result.append(char)
    return ''.join(result)
