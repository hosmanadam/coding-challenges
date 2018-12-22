import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.rot13("test"), "grfg")

    def test2(self):
        self.assertEqual(main.rot13("Test"), "Grfg")


if __name__ == '__main__':
    unittest.main(verbosity=2)
