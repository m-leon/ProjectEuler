/*
* Prompt: What is the 10001st prime number?
*
* Execute: nodejs Problem07.js
*
* Answer: 104743
*/

var limit = Math.pow(2, 17);
var nums = []; // Value = Whether index is prime

// Assume all numbers are prime
nums = new Array(limit).fill(true);

// Start with i = lowest known prime (2)
var primeCount = 0;
for (var i = 2; i <= limit; i++) {
  // Check if this value is still marked as prime
  if (nums[i]) {
    primeCount += 1;
    if (primeCount === 10001) {
      console.log(i);
      return;
    }
    // For all multiples of i, mark as a non-prime
    for (var j = i * i; j < limit; j += i) {
      nums[j] = false;
    }
  }
}
