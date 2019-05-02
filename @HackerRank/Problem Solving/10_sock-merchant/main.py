"""https://www.hackerrank.com/challenges/sock-merchant/problem"""

def sockMerchant(n, ar):
    count = {num: ar.count(num) for num in set(ar)}
    return sum(num//2 for num in count.values())
