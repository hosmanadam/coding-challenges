import unittest

import main


DATA1 = b'\x00' * 16
DUMP1 = '00000000: 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00  ................'

DATA2 = b'CodeWars'
DUMP2 ='00000000: 43 6f 64 65 57 61 72 73                          CodeWars'

DATA3 = b'''\
\x1d\xc4\x15\x25\x91\xe6\x09\x59\x04\x99\x15\x29\x0a\x45\x21\x29\
\x26\x8e\x74\xa0\x1a\xbe\x75\x68\x06\xdd\x70\x33\xa4\x77\x7a\x5d\
\xb1\xba\x22\xa7\xcf\xcc\xf7\xef\xb1\xe3\x13\xed\xf1\x89\xad\xad\
\xb8\x2a\x52\x32\x65\x79\x43\x99\x6f\xc8\xd3\x8e\xb2\x5f\x50\xc9\
\x08\x4a\x12\x25\x79\xc2\xdd\x31\x6b\xb8\x77\x74\x4b\x68\x4b\xd4\
\xdb\x4e\x92\x09\xd5\x4c\x9f\x0b\xfd\xa9\xd1\xd6\x13\xf5\xf8\x81'''
DUMP3 = '''\
00000000: 1d c4 15 25 91 e6 09 59 04 99 15 29 0a 45 21 29  ...%...Y...).E!)
00000010: 26 8e 74 a0 1a be 75 68 06 dd 70 33 a4 77 7a 5d  &.t...uh..p3.wz]
00000020: b1 ba 22 a7 cf cc f7 ef b1 e3 13 ed f1 89 ad ad  ..".............
00000030: b8 2a 52 32 65 79 43 99 6f c8 d3 8e b2 5f 50 c9  .*R2eyC.o...._P.
00000040: 08 4a 12 25 79 c2 dd 31 6b b8 77 74 4b 68 4b d4  .J.%y..1k.wtKhK.
00000050: db 4e 92 09 d5 4c 9f 0b fd a9 d1 d6 13 f5 f8 81  .N...L..........'''


class SampleTests(unittest.TestCase):

    def test1a(self):
        self.assertEqual(main.hexdump(DATA1), DUMP1)

    def test1b(self):
        self.assertEqual(main.dehex(DUMP1), DATA1)

    def test2a(self):
        self.assertEqual(main.hexdump(DATA2), DUMP2)

    def test2b(self):
        self.assertEqual(main.dehex(DUMP2), DATA2)

    def test3a(self):
        self.assertEqual(main.hexdump(DATA3), DUMP3)

    def test3b(self):
        self.assertEqual(main.dehex(DUMP3), DATA3)


if __name__ == '__main__':
    unittest.main(verbosity=2)
