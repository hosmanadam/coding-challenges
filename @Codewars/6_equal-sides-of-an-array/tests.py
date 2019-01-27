import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.find_even_index([1, 2, 3, 4, 3, 2, 1]), 3)

    def test2(self):
        self.assertEqual(main.find_even_index([1, 100, 50, -51, 1, 1]), 1, )

    def test3(self):
        self.assertEqual(main.find_even_index([1, 2, 3, 4, 5, 6]), -1)

    def test4(self):
        self.assertEqual(main.find_even_index([20, 10, 30, 10, 10, 15, 35]), 3)

    def test5(self):
        self.assertEqual(main.find_even_index([20, 10, -80, 10, 10, 15, 35]), 0)

    def test6(self):
        self.assertEqual(main.find_even_index([10, -80, 10, 10, 15, 35, 20]), 6)

    def test7(self):
        self.assertEqual(main.find_even_index(range(1, 100)), -1)

    def test8(self):
        self.assertEqual(main.find_even_index([0, 0, 0, 0, 0]), 0,
                         "Should pick the first index if more cases are valid")

    def test9(self):
        self.assertEqual(main.find_even_index([-1, -2, -3, -4, -3, -2, -1]), 3)

    def test10(self):
        self.assertEqual(main.find_even_index(range(-100, -1)), -1)


if __name__ == '__main__':
    unittest.main(verbosity=2)
