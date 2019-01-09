"""https://www.codewars.com/kata/hex-dump/train/python"""


def hexdump(data):
    lines = [data[i:i+16] for i in range(0, len(data), 16)]
    result = []
    for i, line in enumerate(lines):
        hexa = ' '.join(f'{bte:0>2x}' for bte in line)
        translation = ''.join(chr(bte) if 127 > bte > 31 else '.' for bte in line)
        result.append(f'{i*16:0>8x}: {hexa: <47}  {translation}')
    return '\n'.join(result)


def dehex(text):
    hexa = ''.join(line[10:57] for line in text.split('\n'))
    return bytes.fromhex(hexa)
