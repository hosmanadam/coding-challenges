"""https://projecteuler.net/problem=10"""

from math import sqrt, inf

def prime_generator(max_value=inf, max_yield=inf):
  """
  Yields next prime number when saved to variable and called via next().
  StopIteration when candidate's value exceeds optional max_value parameter.
  StopIteration when optional max_yield number of yields have been made.
  Optimized a numer of ways: cheats 2 on start to simplify logic,
  checks only odd candidates, checks only against confirmed primes,
  and only up to square root of candidate.

  >>> sum(prime_generator(100))
  1060

  >>> primes = prime_generator()
  >>> sum([next(primes) for n in range(100)])
  24133
  """
  yield 2
  confirmed = [2]
  candidate = 3
  while candidate <= max_value and len(confirmed) <= max_yield:
    for divisor in confirmed:
      if divisor > sqrt(candidate):
        confirmed.append(candidate)
        yield candidate
        break
      if candidate%divisor == 0:
        break
    candidate += 2

print(sum(prime_generator(1999999)))
