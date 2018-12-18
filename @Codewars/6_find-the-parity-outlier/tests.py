import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.find_outlier([2, 4, 6, 8, 10, 3]), 3)

    def test2(self):
        self.assertEqual(main.find_outlier([2, 4, 0, 100, 4, 11, 2602, 36]), 11)

    def test3(self):
        self.assertEqual(main.find_outlier([160, 3, 1719, 19, 11, 13, -21]), 160)


if __name__ == '__main__':
    unittest.main(verbosity=2)
