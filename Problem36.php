<?php
/*
* Prompt: Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
*
* Execute: php Problem36.php
*
* Answer: 872187
*/
function isPalindrome($n) {
  return implode(array_reverse(str_split($n))) == $n;
}

$sum = 0;
for ($i = 0; $i < 1000000; $i++) {
  if (isPalindrome($i)) {
    $b = base_convert($i, 10, 2);
    if (isPalindrome($b)) {
      $sum += $i;
    }
  }
}

echo $sum . PHP_EOL;
