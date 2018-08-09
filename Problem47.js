/*
* Prompt: Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
*
* Execute: node Problem47.js
*
* Answer: 134043
*/
const THRESHOLD = 4;

// From https://gist.github.com/jonathanmarvens/7206278
function primeFactorization(number, result) {
  var result = (result || []);
  var root = Math.sqrt(number);
  var x = 2;

  if (number % x) {
    x = 3;

    while ((number % x) && ((x = (x + 2)) < root)) {}
  }

  x = (x <= root) ? x : number;

  result.push(x);

  return (x === number) ? result : primeFactorization((number / x), result);
}

function countDistinct(nFactors, min = THRESHOLD) {
  var count = nFactors.reduce(function(values, v) {
    if (!values.set[v]) {
      values.set[v] = 1;
      values.count++;
    }
    return values;
  }, { set: {}, count: 0 }).count;
  return count >= min;
}

for (var i = 1; true; i++) {
  var commonFactors = { count : 0 };
  var factors  = primeFactorization(i);
  if (!countDistinct(factors))
    continue;
  var bFactors = primeFactorization(i + 1);
  if (!countDistinct(bFactors))
    continue;
  var cFactors = primeFactorization(i + 2);
  if (!countDistinct(cFactors))
    continue;
  var dFactors = primeFactorization(i + 3);
  if (!countDistinct(dFactors))
    continue;
  console.log(i);
  return;
}
