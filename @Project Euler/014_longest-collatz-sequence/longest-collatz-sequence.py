"""https://projecteuler.net/problem=14

The following iterative sequence is defined for the set of positive integers:
n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1)
contains 10 terms. Although it has not been proved yet (Collatz Problem),
it is thought that all starting numbers finish at 1.
Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
"""

"""v4 - Lighter LOOP version optimized at 6.427 seconds
- whenever a sequence reaches a number lower than start, it adds length
previously calculated for that number
- suggestion to only look above 500000 actually doubled runtime, didn't do that"""
def get_collatz_sequence_len(start):
  len = 1
  num = start
  while num > 1:
    if num < start:
      len += lengths[f"{num}"]-1
      break
    if num%2 == 0:
      num = int(num/2)
    else:
      num = 3*num+1
    len += 1
  return len

lengths = {}
for n in range(1, 1000000):
  lengths.update({f"{n}": get_collatz_sequence_len(n)})
print(max(lengths.values()))


# """v3 - Lighter LOOP version at 56.308 seconds
# Doesn't create sequence, just counts its length"""
# def get_collatz_sequence_len(num):
#   len = 1
#   while num > 1:
#     if num%2 == 0:
#       num = int(num/2)
#     else:
#       num = 3*num+1
#     len += 1
#   return len

# longest = {'start': 0, 'length': 0}
# for n in range(1, 1000000):
#   result = get_collatz_sequence_len(n)
#   if result > longest['length']:
#     longest = {'start': n, 'length': result}
# print(longest)


# """v2 - Complete RECURSIVE version at 186.556 seconds"""
# def get_collatz_sequence(num):
#   if num < 2:
#     return [num]
#   if num%2 == 0:
#     num = int(num/2)
#   else:
#     num = 3*num+1
#   return [num] + get_collatz_sequence(num)

# longest = {'start': 0, 'length': 0}
# for n in range(1, 1000000):
#   result = len(get_collatz_sequence(n))
#   if result > longest['length']:
#     longest = {'start': n, 'length': result}
# print(longest)


# """v1 - Complete LOOP version at 106.227 seconds"""
# def get_collatz_sequence(num):
#   sequence = [num]
#   while num > 1:
#     if num%2 == 0:
#       num = int(num/2)
#     else:
#       num = 3*num+1
#     sequence.append(num)
#   return sequence

# longest = {'start': 0, 'length': 0}
# for n in range(1, 1000000):
#   result = len(get_collatz_sequence(n))
#   if result > longest['length']:
#     longest = {'start': n, 'length': result}
# print(longest)
