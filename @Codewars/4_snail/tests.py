import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.snail([[1, 2, 3],
                                     [4, 5, 6],
                                     [7, 8, 9]]),
                         [1, 2, 3, 6, 9, 8, 7, 4, 5])

    def test2(self):
        self.assertEqual(main.snail([[1, 2, 3],
                                     [8, 9, 4],
                                     [7, 6, 5]]),
                         [1, 2, 3, 4, 5, 6, 7, 8, 9])

    def test3(self):
        self.assertEqual(main.snail([[1, 2, 3, 4, 5, 6],
                                     [20, 21, 22, 23, 24, 7],
                                     [19, 32, 33, 34, 25, 8],
                                     [18, 31, 36, 35, 26, 9],
                                     [17, 30, 29, 28, 27, 10],
                                     [16, 15, 14, 13, 12, 11]]),
                         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                          19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36])


if __name__ == '__main__':
    unittest.main(verbosity=2)
