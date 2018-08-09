/*
* Prompt: Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
*
* Execute: node Problem37.js
*
* Answer: 748317
*/

// Sieve primes to arbitrary limit
var limit = 900000;
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

var s = 0; // Sum of found truncatable primes
var c = 0; // Count of found truncatabale primes
loop:
for (var i = 10; c < 11 ; i++) { // 11 is a constant given in the entire prompt
  if (primes[i]) {
    var t = i.toString();
    // Left to right
    for (var j = 0; j < t.length; j++) {
      if(!primes[t.substr(j)])
        continue loop;
    }
    // Right to left
    for (var j = 0; j < t.length; j++) {
      if(!primes[t.substr(0, t.length - j)])
        continue loop;
    }
    // Both true
    c++;
    s += i;
  }
}
console.log(s);
