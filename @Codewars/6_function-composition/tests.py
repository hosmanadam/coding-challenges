import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        add1 = lambda a: a + 1
        this = lambda a: a
        self.assertEqual(main.compose(add1, this)(0), 1)


if __name__ == '__main__':
    unittest.main(verbosity=2)
