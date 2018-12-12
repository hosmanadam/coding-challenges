import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.count_deaf_rats("~O~O~O~O P"), 0)

    def test2(self):
        self.assertEqual(main.count_deaf_rats("P O~ O~ ~O O~"), 1)

    def test3(self):
        self.assertEqual(main.count_deaf_rats("~O~O~O~OP~O~OO~"), 2)


if __name__ == '__main__':
    unittest.main(verbosity=2)
