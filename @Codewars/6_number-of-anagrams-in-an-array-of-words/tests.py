import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.anagram_counter([]), 0, "Is not returning a number")

    def test2(self):
        self.assertEqual(main.anagram_counter(['dell', 'ledl', 'abc', 'cba']), 2)

    def test3(self):
        self.assertEqual(main.anagram_counter(['dell', 'ledl', 'lled', 'cba']), 3)

    def test4(self):
        self.assertEqual(main.anagram_counter(['dell', 'ledl', 'abc', 'cba', 'bca', 'bac', 'cab']), 11)


if __name__ == '__main__':
    unittest.main(verbosity=2)
