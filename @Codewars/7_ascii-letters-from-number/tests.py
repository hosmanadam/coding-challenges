import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.convert("65"),"A")

    def test2(self):
        self.assertEqual(main.convert("656667"),"ABC")

    def test3(self):
        self.assertEqual(main.convert("676584"),"CAT")

    def test4(self):
        self.assertEqual(main.convert("73327673756932858080698267658369"),"I LIKE UPPERCASE")


if __name__ == '__main__':
    unittest.main(verbosity=2)
