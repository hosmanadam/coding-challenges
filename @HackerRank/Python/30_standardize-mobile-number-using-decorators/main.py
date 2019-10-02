"""https://www.hackerrank.com/challenges/standardize-mobile-number-using-decorators/problem"""


def wrapper(f):
    def fun(l):
        return f(map(lambda phone_no: f'+91 {phone_no[-10:-5]} {phone_no[-5:]}', l))
    return fun


@wrapper
def sort_phone(l):
    print(*sorted(l), sep='\n')


if __name__ == '__main__':
    l = [input() for _ in range(int(input()))]
    sort_phone(l)


