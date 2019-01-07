"""https://www.codewars.com/kata/the-hashtag-generator/train/python"""


"""v2 - Uses title() from top CW solution"""
def generate_hashtag(s):
    hashtag = '#' + s.title().replace(' ', '')
    return hashtag if 1 < len(hashtag) < 142 else False


"""v1"""
# def generate_hashtag(s):
    # hashtag = '#' + ''.join(word.lower().capitalize() for word in s.split(' ') if word.strip())
    # return hashtag if 1 < len(hashtag) < 142 else False


"""Top CW solution

- kind of nasty, but it uses title() which I didn't know about
"""
# def generate_hashtag(s):
#     ans = '#'+ str(s.title().replace(' ',''))
#     return s and not len(ans)>140 and ans or False
