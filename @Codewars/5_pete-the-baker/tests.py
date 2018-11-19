import unittest

import main


class SampleTests(unittest.TestCase):

    def test_extra_stock(self):
        """Should ignore extra available ingredients"""
        recipe = {"flour": 500, "sugar": 200, "eggs": 1}
        available = {"flour": 1200, "sugar": 1200, "eggs": 5, "milk": 200}
        self.assertEqual(main.cakes(recipe, available), 2)

    def test_missing_ingredient(self):
        """Should count missing available ingredients as 0"""
        recipe = {"apples": 3, "flour": 300, "sugar": 150, "milk": 100, "oil": 100}
        available = {"sugar": 500, "flour": 2000, "milk": 2000}
        self.assertEqual(main.cakes(recipe, available), 0)


if __name__ == '__main__':
    unittest.main(verbosity=2)
