import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.count('aba'), {'a': 2, 'b': 1})

    def test2(self):
        self.assertEqual(main.count(''), {})


if __name__ == '__main__':
    unittest.main(verbosity=2)
