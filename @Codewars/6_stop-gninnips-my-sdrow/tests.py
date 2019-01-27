import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.spin_words("Welcome"), "emocleW")


if __name__ == '__main__':
    unittest.main(verbosity=2)
