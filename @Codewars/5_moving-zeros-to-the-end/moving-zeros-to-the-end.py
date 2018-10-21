"""https://www.codewars.com/kata/moving-zeros-to-the-end/train/python"""

def move_zeros(array):
  zeros = [0 for item in array if all((item == 0, type(item) in (int, float)))]
  other = [item for item in array if any((item != 0, type(item) not in (int, float)))]
  return other + zeros

# TESTS
print(move_zeros([1,2,0,1,0,1,0,3,0,1])) # [ 1, 2, 1, 1, 3, 1, 0, 0, 0, 0 ]
print(move_zeros([9,0.0,0,9,1,2,0,1,0,1,0.0,3,0,1,9,0,0,0,0,9])) # [9,9,1,2,1,1,3,1,9,9,0,0,0,0,0,0,0,0,0,0]
print(move_zeros(["a",0,0,"b","c","d",0,1,0,1,0,3,0,1,9,0,0,0,0,9])) # ["a","b","c","d",1,1,3,1,9,9,0,0,0,0,0,0,0,0,0,0]
print(move_zeros(["a",0,0,"b",None,"c","d",0,1,False,0,1,0,3,[],0,1,9,0,0,{},0,0,9])) # ["a","b",None,"c","d",1,False,1,3,[],1,9,{},9,0,0,0,0,0,0,0,0,0,0]
print(move_zeros([0,1,None,2,False,1,0])) # [1,None,2,False,1,0,0]
print(move_zeros(["a","b"])) # ["a","b"]
print(move_zeros(["a"])) # ["a"]
print(move_zeros([0,0])) # [0,0]
print(move_zeros([0])) # [0]
print(move_zeros([False])) # [False]
print(move_zeros([])) # []
