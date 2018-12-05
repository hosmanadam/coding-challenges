import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.order("is2 Thi1s T4est 3a"), "Thi1s is2 3a T4est")

    def test2(self):
        self.assertEqual(main.order("4of Fo1r pe6ople g3ood th5e the2"), "Fo1r the2 g3ood 4of th5e pe6ople")


if __name__ == '__main__':
    unittest.main(verbosity=2)
