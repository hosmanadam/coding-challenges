/** https://www.codewars.com/kata/find-the-odd-int/train/javascript */


/** v3 - Kind of ridiculous and also less efficient, but cool */
// const findOdd = A => A.filter(x => (A.filter(y => y === x).length % 2))[0]


/** v2 - Needlessly shortened */
// function findOdd(A) {
//   for (candidate of new Set(A)) {
//     if (A.filter(num => num === candidate).length % 2) {
//         return candidate;
//     }
//   }
// }


/** v1 */
function findOdd(A) {
  uniqueInts = new Set(A);
  for (candidate of uniqueInts) {
    let occurences = A.filter(num => num === candidate).length;
    if (occurences % 2) {
        return candidate;
    }
  }
}
