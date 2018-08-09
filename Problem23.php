<?php
/*
* Prompt: Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*
* Execute: php Problem23.php
*
* Answer: 4179871
*/
/* Returns:
 *  > 0 - Abundant Number
 *    0 - Perfect Number
 *  < 0 - Deficient Number
 */
function d($n) {
  $limit = sqrt($n);
  $sumOfProperDivisors = 1;
  if (floor($limit) == $limit) {
    $sumOfProperDivisors = $limit * -1;
  }
  for ($i = 2; $i <= floor($limit); $i++) {
    if ($n % $i == 0) {
      $sumOfProperDivisors += $i + $n / $i;
    }
  }
  return $sumOfProperDivisors - $n;
}

// #s greater than which can all be written as abundant numbers
$limit = 28123;
$abundantNumbers = [];

$sum = 0;

for ($i = 1; $i < $limit; $i++) {
  if (d($i) > 0) {
    // Put $i as index because it's faster to search by key below than value
    $abundantNumbers[$i] = $i;
  }
  $canBeWrittenAsSum = false;
  foreach ($abundantNumbers as $a) {
    if (array_key_exists($i - $a, $abundantNumbers)) {
      $canBeWrittenAsSum = true;
      break;
    }
  }
  if (!$canBeWrittenAsSum) {
    $sum += $i;
  }
}
echo $sum . PHP_EOL;
