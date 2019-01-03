"""https://www.codewars.com/kata/human-readable-duration-format/train/python"""


def break_down(seconds):
    breakdown = []
    for unit, divisor in ('year', 31536000), ('day', 86400), ('hour', 3600), ('minute', 60), ('second', 1):
        quotient, remainder = divmod(seconds, divisor)
        if quotient >= 1:
            breakdown.append((quotient, unit))
            seconds = remainder
    return breakdown


def pluralize(value, unit):
    return '{} {}s'.format(value, unit) if value > 1 else '{} {}'.format(value, unit)


def conjoin(clauses):
    sentence = ''
    for i, item in enumerate(clauses):
        if i == len(clauses)-1:
            sentence += item
        elif i == len(clauses)-2:
            sentence += '{} and '.format(item)
        else:
            sentence += '{}, '.format(item)
    return sentence


def format_duration(seconds):
    clauses = [pluralize(value, unit) for value, unit in break_down(seconds)]
    sentence = conjoin(clauses)
    return sentence if sentence else 'now'
