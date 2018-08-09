/*
* Prompt: What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
*
* Execute: node Problem38.js
*
* Answer: 932718654
*/

// Tests for 0s and repeated digits
function falsifyPandigital(n) {
  n = n.toString();
  if (n.indexOf("0") > -1) {
    return true;
  }
  for (var i = 1; i < 10; i++) {
    if (n.split(i).length - 1 > 1) {
      return true;
    }
  }
  // Possible pandigital
  return false;
}

function isPandigital(n) {
  // Expect n as an Integer, convert to String
  n = n.toString();
  // Split string into array of characters
  n = n.split('');
  // Sort array
  n.sort();
  // Compare array to known pandigital
  return n.toString() == "1,2,3,4,5,6,7,8,9";
}

var largestConcatenatedProduct = 0;
loop:
for (var n = 1; n < 9999; n++) {
  var concatenatedProduct = "";
  for (var i = 1; ; i++) {
    var p = n * i;
    concatenatedProduct += p.toString();
    if (falsifyPandigital(concatenatedProduct)) {
      continue loop;
    }
    if (isPandigital(concatenatedProduct)) {
      if (parseInt(concatenatedProduct) > largestConcatenatedProduct) {
        largestConcatenatedProduct = concatenatedProduct;
      }
    }
  }
}

console.log(largestConcatenatedProduct);
