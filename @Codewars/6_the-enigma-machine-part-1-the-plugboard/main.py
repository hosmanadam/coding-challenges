"""https://www.codewars.com/kata/the-enigma-machine-part-1-the-plugboard/train/python"""


"""v2 - Cleaned up via assertions and dict.get(), added more validations"""
class Plugboard(object):

    def __init__(self, wires=''):
        """
        :param str wires: Mapping of pairs of characters
        """
        self.mapping = {}
        if wires:
            assert len(wires) <= 20, "Too many wires defined"
            assert wires.isalpha(), "Non-alphabetic characters detected"
            assert len(wires) % 2 == 0, "Dangling wire detected"
            pairs = [wires[i:i+2] for i in range(0, len(wires), 2)]
            assert all(len(set(pair)) == 2 for pair in pairs), "Can't wire character to itself"
            assert len(wires) == len(set(wires)), "Can't wire character to multiple others"
            self.mapping.update({a: b for a, b in pairs})
            self.mapping.update({b: a for a, b in pairs})

    def process(self, c):
        """
        :param str c: Single character to process
        :return: Processed character
        """
        return self.mapping.get(c, c)


"""v1"""
# class Plugboard(object):
#
#     def __init__(self, wires=''):
#         """
#         :param str wires: Mapping of pairs of characters
#         """
#         if len(wires) > 20:
#             raise Exception("Too many wires defined")
#         pairs = [wires[i:i+2] for i in range(0, len(wires), 2)]
#         if any(len(set(pair)) < 2 for pair in pairs):
#             raise Exception("Can't wire character to itself")
#         if len(wires) != len(set(wires)):
#             raise Exception("Can't wire character to multiple others")
#         self.mapping = {}
#         self.mapping.update({a: b for a, b in pairs})
#         self.mapping.update({b: a for a, b in pairs})
#
#     def process(self, c):
#         """
#         :param str c: Single character to process
#         :return: Processed character
#         """
#         if c in self.mapping:
#             return self.mapping[c]
#         else:
#             return c
