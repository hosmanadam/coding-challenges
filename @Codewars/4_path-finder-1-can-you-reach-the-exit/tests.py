import unittest

import main


class SampleTests(unittest.TestCase):

    def test_exitable1(self):
        """Should return `True` if there's a way out"""
        maze = "\n".join([".W.",
                          ".W.",
                          "..."])
        self.assertTrue(main.path_finder(maze))

    def test_exitable2(self):
        """Should return `True` if there's a way out"""
        maze = "\n".join(["......",
                          "......",
                          "......",
                          "......",
                          "......",
                          "......"])
        self.assertTrue(main.path_finder(maze))

    def test_trapped1(self):
        """Should return `False` if there's no way out"""
        maze = "\n".join([".W.",
                          ".W.",
                          "W.."])
        self.assertFalse(main.path_finder(maze))

    def test_trapped2(self):
        """Should return `False` if there's no way out"""
        maze = "\n".join(["......",
                          "......",
                          "......",
                          "......",
                          ".....W",
                          "....W."])
        self.assertFalse(main.path_finder(maze))


if __name__ == '__main__':
    unittest.main(verbosity=2)
