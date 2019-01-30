import unittest

import main


class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEquals(main.money_value("12.34"), 12.34)

    def test2(self):
        self.assertEquals(main.money_value(" $5.67"), 5.67)

    def test3(self):
        self.assertEquals(main.money_value("-0.89"), -0.89)

    def test4(self):
        self.assertEquals(main.money_value("-$ 0.1"), -0.10)

    def test5(self):
        self.assertEquals(main.money_value("$-2.3456"), -2.3456)

    def test6(self):
        self.assertEquals(main.money_value("007"), 7.00)

    def test7(self):
        self.assertEquals(main.money_value(" $ 89"), 89.0)

    def test8(self):
        self.assertEquals(main.money_value("   .11"), 0.11)

    def test9(self):
        self.assertEquals(main.money_value("$.2"), 0.20)

    def test10(self):
        self.assertEquals(main.money_value("-.34"), -0.34)

    def test11(self):
        self.assertEquals(main.money_value("$$$"), 0.0)


if __name__ == '__main__':
    unittest.main(verbosity=2)
