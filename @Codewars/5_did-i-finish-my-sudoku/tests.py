import unittest

import main


class SampleTests(unittest.TestCase):

    def test_correct_solution(self):
        """Should return correct solutions with 'Finished!'"""
        self.assertEqual(main.done_or_not([[1, 3, 2, 5, 7, 9, 4, 6, 8],
                                           [4, 9, 8, 2, 6, 1, 3, 7, 5],
                                           [7, 5, 6, 3, 8, 4, 2, 1, 9],
                                           [6, 4, 3, 1, 5, 8, 7, 9, 2],
                                           [5, 2, 1, 7, 9, 3, 8, 4, 6],
                                           [9, 8, 7, 4, 2, 6, 5, 3, 1],
                                           [2, 1, 4, 9, 3, 5, 6, 8, 7],
                                           [3, 6, 5, 8, 1, 7, 9, 2, 4],
                                           [8, 7, 9, 6, 4, 2, 1, 5, 3]]), 'Finished!')

    def test_incorrect_solution(self):
        """Should return incorrect solutions with 'Try again!'"""
        self.assertEqual(main.done_or_not([[1, 3, 2, 5, 7, 9, 4, 6, 8],
                                           [4, 9, 8, 2, 6, 1, 3, 7, 5],
                                           [7, 5, 6, 3, 8, 4, 2, 1, 9],
                                           [6, 4, 3, 1, 5, 8, 7, 9, 2],
                                           [5, 2, 1, 7, 9, 3, 8, 4, 6],
                                           [9, 8, 7, 4, 2, 6, 5, 3, 1],
                                           [2, 1, 4, 9, 3, 5, 6, 8, 7],
                                           [3, 6, 5, 8, 1, 7, 9, 2, 4],
                                           [8, 7, 9, 6, 4, 2, 1, 3, 5]]), 'Try again!')


if __name__ == '__main__':
    unittest.main(verbosity=2)