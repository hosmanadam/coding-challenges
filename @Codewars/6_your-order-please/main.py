"""https://www.codewars.com/kata/your-order-please/train/python"""


"""v2 - Useless one-liner"""
# def order(sentence):
#    return ' '.join(sorted(sentence.split(' '), key=lambda word: sorted(word)))


"""v1"""
def order(sentence):
   words = sentence.split(' ')
   words = sorted(words, key= lambda word: sorted(word))
   return ' '.join(words)
