function abbrevName(name){
  [first, last] = name.split(' ');
  return `${first[0]}.${last[0]}`.toUpperCase();
}
