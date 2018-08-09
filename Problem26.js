/*
* Prompt: Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*
* Execute: node Problem26.js
*
* Answer: 983
*
* Notes: Requires big-integer library. Use `npm install big-integer`
*/
var bigInt = require("big-integer");

// Sieve for primes
var limit = 1000;
var primes = new Array(limit);
primes.fill(true);
primes[0] = false;
primes[1] = false;
for (var i = 2; i < limit; i++) {
  if (primes[i]) {
    for (j = i * i; j < limit; j += i) {
      primes[j] = false;
    }
  }
}

// From largest prime to smallest
for (var i = primes.length; i-- > 0;) {
  if (primes[i]) {
    if (i == 2 || i == 5) {
      continue;
    }
    var n = bigInt(i);
    var l = 1;
    // Find length of repeating digits of 1 / n using...
    // 10^(l) % n != 1
    // Where == 1, l is equal to the length of the decimal
    while (!bigInt(10).pow(bigInt(l)).mod(n).eq(bigInt.one)) {
      l += 1;
    }
    // From https://blog.dreamshire.com/project-euler-26-solution/
    // Shortcut, no need to test all primes
    if (l + 1 == i) {
      console.log(i);
      break;
    }
  }
}
