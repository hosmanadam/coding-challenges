function whatday(num) { 
  const days = {
    1: "Sunday",
    2: "Monday",
    3: "Tuesday",
    4: "Wednesday",
    5: "Thursday",
    6: "Friday",
    7: "Saturday",
  };
  return (0 < num && num < 8) ? days[num] : 'Wrong, please enter a number between 1 and 7';
}
