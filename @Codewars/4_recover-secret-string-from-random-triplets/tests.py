import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        secret = "whatisup"
        triplets = [
            ['t', 'u', 'p'],
            ['w', 'h', 'i'],
            ['t', 's', 'u'],
            ['a', 't', 's'],
            ['h', 'a', 'p'],
            ['t', 'i', 's'],
            ['w', 'h', 's']
        ]
        self.assertEqual(main.recoverSecret(triplets), secret)


if __name__ == '__main__':
    unittest.main(verbosity=2)
