import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        """Should handle simple tests"""
        self.assertEqual(main.first_non_repeating_letter('a'), 'a')
        self.assertEqual(main.first_non_repeating_letter('stress'), 't')
        self.assertEqual(main.first_non_repeating_letter('moonmen'), 'e')


    def test2(self):
        """Should handle empty strings"""
        self.assertEqual(main.first_non_repeating_letter(''), '')


    def test3(self):
        """Should handle all repeating strings"""
        self.assertEqual(main.first_non_repeating_letter('abba'), '')
        self.assertEqual(main.first_non_repeating_letter('aa'), '')


    def test4(self):
        """Should handle odd characters"""
        self.assertEqual(main.first_non_repeating_letter('~><#~><'), '#')
        self.assertEqual(main.first_non_repeating_letter('hello world, eh?'), 'w')


    def test5(self):
        """Should handle letter cases"""
        self.assertEqual(main.first_non_repeating_letter('sTreSS'), 'T')
        self.assertEqual(main.first_non_repeating_letter('Go hang a salami, I\'m a lasagna hog!'), ',')


if __name__ == '__main__':
    unittest.main(verbosity=2)
