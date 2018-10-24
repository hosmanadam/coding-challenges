"""https://projecteuler.net/problem=7"""

from math import sqrt

"""v1 - Exact copy of my Udemy course version"""
def next_prime():
  candidate = 2
  while True:
    for divisor in range(2, round(sqrt(candidate))+1):
      if candidate%divisor == 0 and divisor != 1:
        break
    else:
      yield candidate
    candidate += 1

primes = next_prime()
primes_to_generate = 10001
prime_set = set()
for thing in (next(primes) for i in range(primes_to_generate)):
  prime_set.add(thing)

print(max(prime_set))
