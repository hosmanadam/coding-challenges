function points(games) {
    let total = 0;
    for (item of games) {
        let [x, y] = item.split(':');
        total = total + ((x>y) ? 3 : (x==y) ? 1 : 0);
    }
  return total;
}
