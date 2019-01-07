import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        """Expected an empty string to return False"""
        self.assertEqual(main.generate_hashtag(''), False)

    def test2(self):
        """Expeted a Hashtag (#) at the beginning."""
        self.assertEqual(main.generate_hashtag('Do We have A Hashtag')[0], '#')

    def test3(self):
        """Should handle a single word."""
        self.assertEqual(main.generate_hashtag('Codewars'), '#Codewars')

    def test4(self):
        """Should handle trailing whitespace."""
        self.assertEqual(main.generate_hashtag('Codewars      '), '#Codewars')

    def test5(self):
        """Should remove spaces."""
        self.assertEqual(main.generate_hashtag('Codewars Is Nice'), '#CodewarsIsNice')

    def test6(self):
        """Should capitalize first letters of words."""
        self.assertEqual(main.generate_hashtag('codewars is nice'), '#CodewarsIsNice')

    def test7(self):
        """Should capitalize all letters of words - all lower case but the first."""
        self.assertEqual(main.generate_hashtag('CodeWars is nice'), '#CodewarsIsNice')

    def test8(self):
        """Should capitalize first letters of words even when single letters."""
        self.assertEqual(main.generate_hashtag('c i n'), '#CIN')

    def test9(self):
        """Should deal with unnecessary middle spaces."""
        self.assertEqual(main.generate_hashtag('codewars  is  nice'), '#CodewarsIsNice')

    def test10(self):
        """Should return False if the final word is longer than 140 chars."""
        self.assertEqual(main.generate_hashtag('Looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong Cat'), False)


if __name__ == '__main__':
    unittest.main(verbosity=2)
