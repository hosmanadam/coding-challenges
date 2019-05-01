"""https://www.hackerrank.com/challenges/mini-max-sum/problem"""

def miniMaxSum(arr):
    sums = [sum(arr) - arr[i] for i in range(len(arr))]
    print(min(sums), max(sums))
