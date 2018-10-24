"""https://projecteuler.net/problem=6"""

"""v2"""
print(sum(range(1,101))**2 - sum({n**2 for n in range(1, 101)}))

"""v1 - Verbose"""
# sum_of_squares = sum({n**2 for n in range(1, 101)})
# square_of_sums = sum(range(1,101))**2
# print(f"Difference between {sum_of_squares} and {square_of_sums} is {square_of_sums-sum_of_squares}.")
