import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.solve('aaaa'), True)

    def test2(self):
        self.assertEqual(main.solve('abba'), False)

    def test3(self):
        self.assertEqual(main.solve('abbba'), True)

    def test4(self):
        self.assertEqual(main.solve('aabbcc'), False)

    def test5(self):
        self.assertEqual(main.solve('aaaabb'), False)

    def test6(self):
        self.assertEqual(main.solve('aabbccddd'), True)

    def test7(self):
        self.assertEqual(main.solve('aabcde'), True)

    def test8(self):
        self.assertEqual(main.solve('abcde'), True)

    def test9(self):
        self.assertEqual(main.solve('aaabcde'), False)

    def test10(self):
        self.assertEqual(main.solve('abbccc'), False)


if __name__ == '__main__':
    unittest.main(verbosity=2)
