import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.persistence(39), 3)
 
    def test2(self):
        self.assertEqual(main.persistence(4), 0)
 
    def test3(self):
        self.assertEqual(main.persistence(25), 2)
 
    def test4(self):
        self.assertEqual(main.persistence(999), 4)


if __name__ == '__main__':
    unittest.main(verbosity=2)
