import unittest

import main
from text import UNBROKEN, JUSTIFIED


class SampleTests(unittest.TestCase):

    def test_lorem_ipsum(self):
        self.assertEqual(main.justify(UNBROKEN, 30), JUSTIFIED)


if __name__ == '__main__':
    unittest.main(verbosity=2)
