"""https://www.codewars.com/kata/valid-parentheses/train/python"""

"""v2 - Needlessly shortened for practice"""
def valid_parentheses(s):
  return (s.count('(') == s.count(')') and 
          all((s[:i].count('(') >= s[:i].count(')')) for i in range(len(s))))

"""v1 - Copied from '2018. 05. 20. PYTHON training @Udemy/376_valid_parentheses'"""
# def valid_parentheses(string):
#   if string.count("(") == string.count(")"):
#     for i in range(len(string)):
#       if string[:i].count("(") < string[:i].count(")"):
#         return False
#     return True
#   return False

"""Top CW solution - handles both requirements in one logic"""
# def valid_parentheses(string):
#   cnt = 0
#   for char in string:
#     if char == '(': cnt += 1
#     if char == ')': cnt -= 1
#     if cnt < 0: return False
#   return True if cnt == 0 else False


# TESTS
print(valid_parentheses("()")) # True 
print(valid_parentheses(")(()))")) # False 
print(valid_parentheses("(")) # False 
print(valid_parentheses("(())((()())())")) # True 
print(valid_parentheses('))((')) # False
print(valid_parentheses('())(')) # False
print(valid_parentheses('()()()()())()(')) # False
print(valid_parentheses('())(()')) # False
