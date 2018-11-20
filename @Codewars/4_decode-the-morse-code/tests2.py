import unittest

import part1, part2


class SampleTests(unittest.TestCase):

    def test(self):
        self.assertEqual(part1.decodeMorse(part2.decodeBits(
            '1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011')),
            'HEY JUDE')


if __name__ == '__main__':
    unittest.main(verbosity=2)
