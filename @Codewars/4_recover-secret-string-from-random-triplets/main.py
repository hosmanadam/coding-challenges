"""https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/python"""


"""v2 - Plain loop"""
def recoverSecret(triplets):
    triplets = [''.join(triplet) for triplet in triplets]
    unique_chars = set(''.join(triplets))
    found = ''
    while len(found) < len(unique_chars):
        for char in unique_chars - set(found):
            triplets_including_char = [triplet.lstrip(found) for triplet in triplets if char in triplet]
            is_match = all(triplet[0] == char for triplet in triplets_including_char)
            if is_match:
                found += char
                break
    return found


"""v1 - Recursive solution"""
# def recoverSecret(triplets):
#     def inner(triplets, unique_chars, found=''):
#         if len(found) == len(unique_chars):
#             return found
#         for char in unique_chars - set(found):
#             triplets_including_char = [triplet.lstrip(found) for triplet in triplets if char in triplet]
#             is_match = all(triplet[0] == char for triplet in triplets_including_char)
#             if is_match:
#                 return inner(triplets, unique_chars, found + char)
#     triplets = [''.join(triplet) for triplet in triplets]
#     unique_chars = set(''.join(triplets))
#     return inner(triplets, unique_chars)
