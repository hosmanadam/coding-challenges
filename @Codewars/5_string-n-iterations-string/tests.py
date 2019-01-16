import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual("Sc o!uhWw", main.jumbled_string("Such Wow!", 1))

    def test2(self):
        self.assertEqual("bexltept merae", main.jumbled_string("better example", 2))

    def test3(self):
        self.assertEqual("qtorieuwy", main.jumbled_string("qwertyuio", 2))

    def test4(self):
        self.assertEqual("Gtsegenri", main.jumbled_string("Greetings", 8))


class CustomTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.get_multiplicative_order(0), 1)
        self.assertEqual(main.get_multiplicative_order(1), 1)
        self.assertEqual(main.get_multiplicative_order(2), 1)

    def test2(self):
        self.assertEqual(main.get_multiplicative_order(19), 18)
        self.assertEqual(main.get_multiplicative_order(20), 18)


if __name__ == '__main__':
    unittest.main(verbosity=2)
