"""https://www.codewars.com/kata/5842df8ccbd22792a4000245/train/python"""

def expanded_form(num):
  """v2 - short"""
  nums = str(num)
  zeroes = [x*'0' for x in range(len(nums)-1, -1, -1)]
  output = [nums[i] + zeroes[i] for i in range(len(nums)) if nums[i] != '0']
  return ' + '.join(output)

# def expanded_form(num):
#   """v1 - readable"""
#   nums = str(num)
#   zeroes = [x*'0' for x in range(len(nums)-1, -1, -1)]
#   output = ''
#   for i in range(len(nums)):
#     if nums[i] == '0':
#       continue
#     if output != '':
#       output += ' + '
#     output += nums[i] + zeroes[i]
#   return output


# TESTS
print(expanded_form(42))
print(expanded_form(70304))
print(expanded_form(765234606))
