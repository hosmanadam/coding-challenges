"""https://www.codewars.com/kata/pick-peaks/train/python"""


"""v3 - More intentional, doesn't rely on errors, faster"""
def pick_peaks(arr):
  pos, peaks = [], []
  for i in range(1, len(arr)-1):
      previous, current = arr[i-1], arr[i]
      later_different = [x for x in arr[i+1:] if x != current]
      if not later_different: break
      next_different = later_different[0]
      if previous < current > next_different:
        pos.append(i)
        peaks.append(current)
  return {"pos": pos, "peaks": peaks}


"""v2 - Same without ternary operator: works in Python 2.7.6"""
# def pick_peaks(arr):
#   pos, peaks = [], []
#   for i, num in enumerate(arr):
#     try:
#       if i > 0: previous = arr[i-1]
#       next_different = [x for x in arr[i+1:] if x != num][0]
#       if previous < num > next_different:
#         pos.append(i)
#         peaks.append(num)
#     except: continue
#   return {"pos": pos, "peaks": peaks}


"""v1 - Works in Python 3.7, but not in 2.7.6"""
# def pick_peaks(arr):
#   pos, peaks = [], []
#   for i, num in enumerate(arr):
#     try:
#       previous = arr[i-1] if i > 0 else None
#       next_different = [x for x in arr[i+1:] if x != num][0]
#       if previous < num > next_different:
#         pos.append(i)
#         peaks.append(num)
#     except: continue
#   return {"pos": pos, "peaks": peaks}


# TESTS

print('should support finding peaks')
print(pick_peaks([1,2,3,6,4,1,2,3,2,1])) # {"pos":[3,7], "peaks":[6,3]}

print('should support finding peaks, but should ignore peaks on the edge of the array')
print(pick_peaks([3,2,3,6,4,1,2,3,2,1,2,3])) # {"pos":[3,7], "peaks":[6,3]}

print('should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau')
print(pick_peaks([3,2,3,6,4,1,2,3,2,1,2,2,2,1])) # {"pos":[3,7,10], "peaks":[6,3,2]}
print(pick_peaks([2,1,3,1,2,2,2,2,1])) # {"pos":[2,4], "peaks":[3,2]}

print('should support finding peaks, but should ignore peaks on the edge of the array')
print(pick_peaks([2,1,3,1,2,2,2,2])) # {"pos":[2], "peaks":[3]}
