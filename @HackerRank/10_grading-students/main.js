/* https://www.hackerrank.com/challenges/grading/problem */

function gradingStudents(grades) {
    const roundGrade = (grade) => {
        let belowBy = 5 - grade % 5;
        if (grade > 37 && belowBy < 3) {
            return grade + belowBy;
        }
        return grade;
    }
    return grades.map(roundGrade);
}
