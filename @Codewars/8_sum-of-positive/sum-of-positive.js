function positiveSum(arr) {
  return [0].concat(arr).reduce((total, amount) => total + ((amount > 0) ? amount : 0));
}
