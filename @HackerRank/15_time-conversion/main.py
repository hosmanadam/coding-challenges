"""https://www.hackerrank.com/challenges/time-conversion/problem"""


def timeConversion(s):
    hour = int(s[:2])
    if s[-2:]=='AM':
        new_hour = s[:2] if hour < 12 else '00'
    else:
        new_hour = str(hour + 12) if hour < 12 else '12'
    return new_hour + s[2:-2]
