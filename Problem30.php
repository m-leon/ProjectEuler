<?php
/*
* Prompt: Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*
* Execute: php Problem30.php
*
* Answer: 443839
*/
function n($n) {
  $digits = str_split($n);
  $sum = 0;
  foreach ($digits as $d) {
    $sum += pow($d, 5);
  }
  return $n === $sum;
}

$sum = 0;
$limit = 450000; // Arbitrary
for ($i = 1000; $i < $limit; $i++) {
  if (n($i)) {
    $sum += $i;
  }
}

echo $sum . PHP_EOL;
