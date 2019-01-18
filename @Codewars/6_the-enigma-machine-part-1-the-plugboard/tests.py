import unittest

import main


class SampleTests(unittest.TestCase):

    def setUp(self):
        self.plugboard = main.Plugboard("AB")

    def test1(self):
        self.assertRaises(
            Exception,
            lambda: main.Plugboard("ABCDEFGHIJKLMNOPQRSTUV"))

    def test2(self):
        self.assertEqual(self.plugboard.process('A'), 'B')

    def test3(self):
        self.assertEqual(self.plugboard.process('B'), 'A')

    def test4(self):
        self.assertEqual(self.plugboard.process('C'), 'C')


if __name__ == '__main__':
    unittest.main(verbosity=2)
