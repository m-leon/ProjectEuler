<?php
/*
* Prompt: Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*
* Execute: php Problem52.php
*
* Answer: 142857
*/
function compareStrings($a, $b) {
  $a = str_split($a);
  $b = str_split($b);
  return (array_diff($a, $b) === array_diff($b, $a));
}

for ($i = 10; ; $i++) {
  $n[0] = $i * 2;
  $n[1] = $i * 3;
  $n[2] = $i * 4;
  $n[3] = $i * 5;
  $n[4] = $i * 6;
  for ($j = 0; $j < count($n); $j++) {
    if (!compareStrings($i, $n[$j])) {
      continue 2;
    }
  }
  echo $i . PHP_EOL;
  exit;
}
