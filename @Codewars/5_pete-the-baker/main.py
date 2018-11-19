"""https://www.codewars.com/kata/pete-the-baker/train/python"""


"""v2 - A bit less efficient, but short and readable"""
def cakes(recipe, stock):
    return min(stock[item]//recipe[item] if item in stock else 0 for item in recipe)


"""v1 - Works, but a bit long for what it does"""
# def cakes(recipe, available):
#     max_cakes = None
#     for ingredient, amount_required in recipe.items():
#         if ingredient not in available:
#             return 0
#         amount_available = available[ingredient]
#         ingredient_enough_for = amount_available//amount_required
#         if max_cakes == None or ingredient_enough_for < max_cakes:
#             max_cakes = ingredient_enough_for
#     return max_cakes
