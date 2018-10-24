"""https://www.codewars.com/kata/human-readable-time/train/python"""

def make_readable(seconds):
  HH = seconds//3600
  MM = seconds%3600//60
  SS = seconds%60
  return ':'.join(str(x).zfill(2) for x in (HH, MM, SS))

"""Top CW solution - calculates inside .format() method"""
# def make_readable(s):
#   return '{:02}:{:02}:{:02}'.format(s / 3600, s / 60 % 60, s % 60)


# TESTS
print(make_readable(0)) # "00:00:00"
print(make_readable(5)) # "00:00:05"
print(make_readable(60)) # "00:01:00"
print(make_readable(86399)) # "23:59:59"
print(make_readable(359999)) # "99:59:59"
