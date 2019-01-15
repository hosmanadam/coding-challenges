import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.binary_to_string('0100100001100101011011000110110001101111'), 'Hello')

    def test2(self):
        self.assertEqual(main.binary_to_string('00110001001100000011000100110001'), '1011')


if __name__ == '__main__':
    unittest.main(verbosity=2)
