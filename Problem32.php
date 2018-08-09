<?php
/*
* Prompt: Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
*
* Execute: php Problem32.php
*
* Answer: 45228
*/
function isPandigital($a, $b, $c) {
  $t = str_split($a . $b . $c);
  sort($t);
  return ($t == [1,2,3,4,5,6,7,8,9]);
}

$n = array();

for ($a = 1; $a < 999; $a++) {
  for ($b = 1; ; $b++) {
    $p = $a * $b;
    if ($p > 9999)
      break;
    if (isPandigital($a, $b, $p)) {
      $n[] = $p;
    }
  }
}

$n = array_unique($n);
$s = 0;

foreach ($n as $i) {
  $s += $i;
}

echo $s . PHP_EOL;
