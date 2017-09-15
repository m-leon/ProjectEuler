<?php
/*
* Prompt: Evaluate the sum of all the amicable numbers under 10000.
*
* Execute: php Problem21.php
*
* Answer: 31626
*/
function sumOfD($n) {
  $sum = 0;
  for ($i = 1; $i < $n; $i++) {
    if ($n % $i == 0) {
      $sum += $i;
    }
  }
  return $sum;
}

$v = array();
$s = 0;
for ($i = 1; $i < 10000; $i++) {
  $v[$i] = sumOfD($i);
  if ($i != $v[$i] && array_key_exists($v[$i], $v) && $v[$v[$i]] == $i) {
    $s += $i;
    $s += $v[$i];
  }
}

echo $s . PHP_EOL;
