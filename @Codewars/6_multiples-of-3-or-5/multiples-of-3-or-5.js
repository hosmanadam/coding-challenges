/** https://www.codewars.com/kata/multiples-of-3-or-5/train/javascript */


/** v2 - More readable and efficient */
function solution(number) {
  if (number < 3) {return 0};
  let range = [...Array(number).keys()];
  let multiples = range.filter(num => (num%3 === 0 || num%5 === 0));
  return multiples.reduce(((accumulator, next) => accumulator + next));
}


/** v1 */
// function solution(number) {
//   let range = [...Array((number > 0) ? number : 0).keys()];
//   let multiples = range.filter(num => (num%3 === 0 || num%5 === 0));
//   return multiples.reduce(((accumulator, next) => accumulator + next), 0);
// }
