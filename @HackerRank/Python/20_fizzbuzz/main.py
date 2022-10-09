"""https://www.hackerrank.com/challenges/fizzbuzz/problem"""

for n in range(1,101):print(('Fizz'*(n%3==0)+'Buzz'*(n%5==0)) or str(n))