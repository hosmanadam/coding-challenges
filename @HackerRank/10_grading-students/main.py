"""https://www.hackerrank.com/challenges/grading/problem"""

def gradingStudents(grades):
    def round_grade(grade):
        below_by = 5 - grade % 5
        if grade > 37 and below_by < 3:
            return grade + below_by
        return grade
    return [round_grade(grade) for grade in grades]
