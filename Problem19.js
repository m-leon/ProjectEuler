/*
* Prompt: How many Sundays fell on the first of the month during the twentieth century?
*
* Execute: node Problem19.js
*
* Answer: 171
*
* Notes: Brute force answer. 6ms execution
*/
var current = {
  weekday: 0, // 0 = Monday, 6 = Sunday
  day: 1,
  month: 1,
  year: 1900,
  monthlength: 999
};

count = 0;

while (true) {
  if (current.day == 1) {
    // Calculate days in month
    if (current.month == 2) {
      current.monthlength = 28;
      if (current.year % 4 == 0) { // Leap year?
        if (current.year % 100 == 0) {
          if (current.year % 400 == 0) {
            current.monthlength = 29;
          }
        } else {
          current.monthlength = 29;
        }
      }
    } else if ([4, 6, 9, 11].indexOf(current.month) >= 0) { // 30 day
      current.monthlength = 30;
    } else { // 31 days
      current.monthlength = 31;
    }
  }

  current.day += 1;
  if (current.day > current.monthlength) {
    current.day = 1;
    current.month += 1;
    if (current.month > 12) {
      current.month = 1;
      current.year += 1;
      if (current.year > 2000) {
        break;
      }
    }
  }

  current.weekday += 1;
  if (current.weekday > 6) {
    current.weekday = 0; // Wrap to Monday
  }

  if (current.year != 1900) { // Not part of the 20th century
    if (current.day == 1 && current.weekday == 6) {
      count += 1;
    }
  }
}

console.log(count);
