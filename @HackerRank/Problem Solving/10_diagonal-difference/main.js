/* https://www.hackerrank.com/challenges/diagonal-difference/problem */

function diagonalDifference(arr) {
    let size = arr.length;
    let indexes = [...Array(size).keys()];
    let lrSum = indexes
        .map(i => arr[i][i])
        .reduce((x, y) => x + y);
    let rlSum = indexes
        .map(i => arr[i][size - i - 1])
        .reduce((x, y) => x + y);
    return Math.abs(lrSum - rlSum);
}

let arr1 = [[1, 2, 3], [4, 5, 6], [9, 8, 9]]; // 2
console.log(diagonalDifference(arr1));

let arr2 = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]; // 15
console.log(diagonalDifference(arr2));
