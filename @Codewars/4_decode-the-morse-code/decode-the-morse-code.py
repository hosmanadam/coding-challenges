morse = (".---- ..--- ...-- ....- ..... -.... --... ---.. ----. ----- "
         ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- "
         ".--. --.- .-. ... - ..- ...- .-- -..- -.-- --..").split(' ')
abc = '1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ'
MORSE_CODE = dict(zip(morse, abc))


"""PART 1: https://www.codewars.com/kata/decode-the-morse-code/train/python"""

def decodeMorse(morse_code):
  output = []
  for word in [word.split(' ') for word in morse_code.strip().split('   ')]:
    output.append(''.join([MORSE_CODE[char] for char in word]))
  return ' '.join(output)

# # TESTS
# print(decodeMorse('    ... --- ...   ... --- ...'))
# print(decodeMorse('.... . -.--   .--- ..- -.. .'))


"""PART 2: https://www.codewars.com/kata/decode-the-morse-code-advanced/train/python"""

import re

def find_sampling_rate(bits):
  """v2 - With RegEx"""
  for i in range(1, len(bits)+1):
    for bit in '01':
      if re.search(f"[^{bit}][{bit}]{{{i}}}[^{bit}]", bits):
        return i

# def find_sampling_rate(bits):
#   """v1 - Plain old logic"""
#   shortest = len(bits)
#   current = ''
#   for i in range(len(bits)):
#     if current == '' or bits[i] == current[-1]:
#       current += bits[i]
#     else:
#       if len(current) < shortest:
#         shortest = len(current)
#       current = bits[i]
#   return shortest

# def find_sampling_rate(bits):
#   """Not mine, but nice... Short but more readable."""
#   return min(len(m) for m in re.findall(r'1+|0+', bits))

def decodeBits(bits):
  bits = bits.strip('0')
  sampling_rate = find_sampling_rate(bits)
  bits = bits[::sampling_rate]
  bit_to_morse = [('0000000', '   '),
                  ('000', ' '),
                  ('111', '-'),
                  ('0', ''),
                  ('1', '.')]
  for pair in bit_to_morse:
    bits = bits.replace(pair[0], pair[1])
  return bits

# TESTS
print(decodeMorse(decodeBits('1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011')))


"""PART 3: http://www.codewars.com/kata/decode-the-morse-code-for-real/train/python"""

# TODO
