"""https://www.codewars.com/kata/maximum-subarray-sum/train/python"""

"""v2 - Hahaha, funny because I made it and it works but I don't know how"""
# def maxSequence(arr):
#   if all(n<0 for n in arr) or not arr: return 0
#   return max([max([sum(arr[i:j]) for j in range(i+1, len(arr)+1)]) for i in range(len(arr))])

"""v1"""
def maxSequence(arr):
  if all(n<0 for n in arr) or not arr:
    return 0
  maximum = arr[0]
  for i in range(0, len(arr)):
    for j in range(i+1, len(arr)+1):
      prod = sum(arr[i:j])
      if prod > maximum:
        maximum = prod
  return maximum


# TESTS
print(maxSequence([])) # 0
print(maxSequence([-2, 1, -3, 4, -1, 2, 1, -5, 4])) # 6
print(maxSequence([-2, -1, -3, -4, -1, -2, -1, -5, -4])) # 0
