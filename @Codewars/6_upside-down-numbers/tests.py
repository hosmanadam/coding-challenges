import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.solve(0, 10), 3)

    def test2(self):
        self.assertEqual(main.solve(10, 100), 4)

    def test3(self):
        self.assertEqual(main.solve(100, 1000), 12)

    def test4(self):
        self.assertEqual(main.solve(1000, 10000), 20)

    def test5(self):
        self.assertEqual(main.solve(10000, 15000), 6)

    def test6(self):
        self.assertEqual(main.solve(15000, 20000), 9)

    def test7(self):
        self.assertEqual(main.solve(60000, 70000), 15)

    def test8(self):
        self.assertEqual(main.solve(60000, 130000), 55)


if __name__ == '__main__':
    unittest.main(verbosity=2)
