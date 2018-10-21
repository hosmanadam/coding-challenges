"""https://www.codewars.com/kata/money-money-money/train/python"""

def calculate_years(principal, interest, tax, desired):
  amount = principal
  years = 0
  while amount < desired:
    yearly_interest = amount*interest
    yearly_tax = yearly_interest*tax
    amount += yearly_interest-yearly_tax
    years += 1
  return years
