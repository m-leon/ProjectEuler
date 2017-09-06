/*
* Prompt: Find the sum of all the primes below two million.
*
* Execute: nodejs Problem10.js
*
* Answer: 142913828922
*/
var limit = 2000000;
var nums = []; // Value = Whether index is prime

// Assume all numbers are prime
nums = new Array(limit).fill(true);

// Start with i = lowest known prime (2)
var sum = 0;
for (var i = 2; i <= limit; i++) {
  // Check if this value is still marked as prime
  if (nums[i]) {
    sum += i;
    // For all multiples of i, mark as a non-prime
    for (var j = i * i; j <= limit; j += i) {
      nums[j] = false;
    }
  }
}

console.log(sum);
