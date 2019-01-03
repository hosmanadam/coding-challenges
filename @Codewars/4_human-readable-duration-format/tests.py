import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.format_duration(1), "1 second")

    def test2(self):
        self.assertEqual(main.format_duration(62), "1 minute and 2 seconds")

    def test3(self):
        self.assertEqual(main.format_duration(120), "2 minutes")

    def test4(self):
        self.assertEqual(main.format_duration(3600), "1 hour")

    def test5(self):
        self.assertEqual(main.format_duration(3662), "1 hour, 1 minute and 2 seconds")


if __name__ == '__main__':
    unittest.main(verbosity=2)
