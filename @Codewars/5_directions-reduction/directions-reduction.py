"""https://www.codewars.com/kata/directions-reduction/train/python"""

def dirReduc(arr):
  OPPOSITES = ({"EAST", "WEST"},
               {"NORTH", "SOUTH"})
  for i in range(len(arr)//2):
    for j in range(len(arr)-1):
      if set(arr[j:j+2]) in OPPOSITES:
        del arr[j:j+2]
  return arr

# TESTS
print(dirReduc(["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"])) # ['WEST']
print(dirReduc(["NORTH", "WEST", "SOUTH", "EAST"])) # ["NORTH", "WEST", "SOUTH", "EAST"]
print(dirReduc(["NORTH", "NORTH", "NORTH", "NORTH", "NORTH", "SOUTH", "SOUTH", "SOUTH", "SOUTH", "SOUTH"])) # [] ← to test outer loop limit
print(dirReduc(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"])) # ["WEST", "WEST"]
