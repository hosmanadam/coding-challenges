import unittest

import part1


class SampleTests(unittest.TestCase):

    def test_heyjude(self):
        self.assertEqual(part1.decodeMorse('.... . -.--   .--- ..- -.. .'), 'HEY JUDE')


class CustomTests(unittest.TestCase):

    def test_sos(self):
        self.assertEqual(part1.decodeMorse('    ... --- ...   ... --- ...'), 'SOS SOS')


if __name__ == '__main__':
    unittest.main(verbosity=2)
