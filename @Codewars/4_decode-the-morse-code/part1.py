"""https://www.codewars.com/kata/decode-the-morse-code/train/python"""

from morse import MORSE_CODE

def decodeMorse(morse_code):
    output = []
    for word in [word.split(' ') for word in morse_code.strip().split('   ')]:
        output.append(''.join([MORSE_CODE[char] for char in word]))
    return ' '.join(output)
