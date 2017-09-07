/*
* Prompt: What is the value of the first triangle number to have over five hundred divisors?
*
* Execute: nodejs Problem12.js
*
* Answer: 76576500
*/
function count_divsors(num) {
  var c = 0;
  for (var d = 1; d <= Math.floor(Math.sqrt(num)); d++) {
    if (num % d == 0) {
      c += 2;
    }
    if (d*d == num) {
      c -= 1;
    }
  }
  return c;
}

function triangle(n) {
  var triangular = 0;
  for (var i = 0; i <= n; i++) {
    triangular += i;
  }
  return triangular;
}

for (var i = 1; ; i++) {
  var t = triangle(i);
  if (count_divsors(t) > 500) {
    console.log(t);
    return;
  }
}
