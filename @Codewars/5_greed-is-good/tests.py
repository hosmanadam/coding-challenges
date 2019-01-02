import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.score([2, 3, 4, 6, 2]), 0)

    def test2(self):
        self.assertEqual(main.score([4, 4, 4, 3, 3]), 400)

    def test3(self):
        self.assertEqual(main.score([2, 4, 4, 5, 4]), 450)


if __name__ == '__main__':
    unittest.main(verbosity=2)
