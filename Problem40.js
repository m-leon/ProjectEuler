/*
* Prompt: An irrational decimal fraction is created by concatenating the positive integers. What is the value of d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000?
*
* Execute: node Problem40.js
*
* Answer: 210
*/

var d = "";
var n = 1;
while (d.length < Math.pow(10, 6)) {
  d += n.toString();
  n++;
}

var p = 1;
for (var i = 0; i < 7; i++) {
  var j = Math.pow(10, i) - 1;
  p *= d.charAt(parseInt(j));
}

console.log(p);
