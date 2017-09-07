<?php
/*
* Prompt: Which starting number, under one million, produces the longest [collatz] chain?
*
* Execute: php Problem14.php
*
* Answer: 837799
*/
function getNextN($n) {
  if ($n == 1)
    return false;
  if ($n % 2 == 0)
    return $n / 2;
  return 3 * $n + 1;
}

function countSequence($n) {
  $count = 0;
  while ($n) {
    $n = getNextN($n);
    $count++;
  }
  return $count;
}

$max = 0;
$maxIndex = 0;
for ($i = 1; $i <= 1000000; $i++) {
  $count = countSequence($i);
  if ($count > $max) {
    $maxIndex = $i;
    $max = $count;
  }
}

echo $maxIndex . PHP_EOL;
