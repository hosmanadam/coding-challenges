/* https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/javascript */


/* v2 - Plain loop */
const recoverSecret = (triplets) => {
  const TRIPLETS = triplets.map((triplet) => (triplet.join('')));
  const UNIQUE_CHARACTERS = [...(new Set(TRIPLETS.join('')))];
  let found = '';
  while (found.length < UNIQUE_CHARACTERS.length) {
    let remainingUniqueCharacters = UNIQUE_CHARACTERS.filter((char) => !(found.includes(char)));
    for (let char of remainingUniqueCharacters) {
      let tripletsIncludingChar = TRIPLETS.filter((triplet) => (triplet.includes(char)));
      let re = new RegExp(`[${found}]`, 'g');
      tripletsIncludingChar = tripletsIncludingChar.map(triplet => triplet.replace(re, ''));
      let isMatch = tripletsIncludingChar.every(triplet => triplet[0] === char);
      if (isMatch) {
        found += char;
        break;
      }
    }
  }
  return found;
};


/* v1 - Recursive solution */
// const recoverSecret = (triplets) => {
//   const inner = (triplets, uniqueCharacters, found='') => {
//     if (found.length === uniqueCharacters.length) {
//       return found
//     }
//     let remainingUniqueCharacters = uniqueCharacters.filter((char) => !(found.includes(char)));
//     for (let char of remainingUniqueCharacters) {
//       let tripletsIncludingChar = triplets.filter((triplet) => (triplet.includes(char)));
//       let re = new RegExp(`[${found}]`,'g');
//       tripletsIncludingChar = tripletsIncludingChar.map(triplet => triplet.replace(re, ''));
//       let isMatch = tripletsIncludingChar.every(triplet => triplet[0] === char);
//       if (isMatch) {
//         return inner(triplets, uniqueCharacters, found + char)
//       }
//     }
//   };
//   const TRIPLETS  = triplets.map((triplet) => (triplet.join('')));
//   const UNIQUE_CHARACTERS = [...(new Set(TRIPLETS.join('')))];
//   return inner(TRIPLETS, UNIQUE_CHARACTERS)
// };



/* TEST */
const triplets = [
  ['t', 'u', 'p'],
  ['w', 'h', 'i'],
  ['t', 's', 'u'],
  ['a', 't', 's'],
  ['h', 'a', 'p'],
  ['t', 'i', 's'],
  ['w', 'h', 's']
];

console.log(recoverSecret(triplets));  // 'whatisup'
