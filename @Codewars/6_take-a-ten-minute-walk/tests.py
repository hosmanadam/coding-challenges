import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEqual(main.isValidWalk(['s', 's', 'e', 's', 'e', 'w']), False)

    def test2(self):
        self.assertEqual(main.isValidWalk(['e', 's', 's', 'w', 's', 'n', 'e', 'e',
                                           'w', 'e', 'e', 's']), False)

    def test3(self):
        self.assertEqual(main.isValidWalk(['e', 'n', 'n', 'n', 'n', 's', 'n', 's',
                                           's', 'w', 'e', 's', 's', 'w', 'n', 'e', 's']), False)

    def test4(self):
        self.assertEqual(main.isValidWalk(['w', 's', 's', 'e', 'e', 's', 's', 'e',
                                           'n', 'e', 'n', 's', 's', 's', 'w', 's', 'e', 'e']), False)

    def test5(self):
        self.assertEqual(main.isValidWalk(['e', 'n', 'e', 's', 'w', 'n', 's', 's',
                                           'n', 'w', 'e', 'e', 'w', 's', 'w', 's']), False)

    def test6(self):
        self.assertEqual(main.isValidWalk(['s', 'e', 's', 'e', 's', 'w']), False)

    def test7(self):
        self.assertEqual(main.isValidWalk(['n']), False)

    def test8(self):
        self.assertEqual(main.isValidWalk(['e', 'w', 's', 's', 'e', 'n', 'w', 'w']), False)

    def test9(self):
        self.assertEqual(main.isValidWalk(['s', 'e', 's', 'n', 's', 'e', 's', 'w',
                                           'n', 'e', 'w', 's', 'n', 'e', 'n']), False)

    def test10(self):
        self.assertEqual(main.isValidWalk(['e', 'n']), False)

    def test11(self):
        self.assertEqual(main.isValidWalk(['w', 'w', 'w', 'e', 'e', 'e', 's', 's', 'n', 'n']), True)


if __name__ == '__main__':
    unittest.main(verbosity=2)
