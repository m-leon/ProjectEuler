/*
* Prompt: Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
*
* Execute: node Problem56.js
*
* Answer: 972
*
* Notes: Requires big-integer library. Use `npm install big-integer`
*/
var bigInt = require("big-integer");

function digitalSum(n) {
  n = n.toString(10);
  var sum = 0;
  var i = n.length;
  while(i--) {
    sum += parseInt(n[i]);
  }
  return sum;
}

var maxDigitalSum = 0;
for (var a = 1; a <= 100; a++) {
  for (var b = 1; b <= 100; b++) {
     var p = bigInt(a).pow(b);
     var s = digitalSum(p);
     if (s > maxDigitalSum) {
       maxDigitalSum = s;
     }
  }
}

console.log(maxDigitalSum);
