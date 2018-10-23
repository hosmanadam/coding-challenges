"""https://www.codewars.com/kata/rgb-to-hex-conversion/train/python"""

# def rgb(r, g, b):
#   """v2 - Same, made to work in Python 2.7.6"""
#   rgb = [0 if n < 0 else 255 if n > 255 else n for n in (r, g, b)]
#   hex = ['{0:0>2X}'.format(n) for n in rgb]
#   return ''.join(hex)

def rgb(r, g, b):
  """v1"""
  rgb = [0 if n < 0 else 255 if n > 255 else n for n in (r, g, b)]
  hex = [f'{n:0>2X}' for n in rgb]
  return ''.join(hex)

# def rgb(r, g, b):
#   """Top CW solution, uses `clamp()`
#   - seems convoluted at first, but appears to be common practice, so good to know"""
#   clamp = lambda x: min(255, max(x, 0))
#   return ("{:02X}" * 3).format(clamp(r), clamp(g), clamp(b))


# TESTS
print(rgb(0,0,0)) #"000000", "testing zero values"
print(rgb(1,2,3)) # "010203", "testing near zero values"
print(rgb(255,255,255)) # "FFFFFF", "testing max values"
print(rgb(254,253,252)) # "FEFDFC", "testing near max values"
print(rgb(-20,275,125)) # "00FF7D", "testing out of range values"
