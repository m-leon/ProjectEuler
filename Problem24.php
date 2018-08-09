<?php
/*
* Prompt: What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*
* Execute: php Problem24.php
*
* Answer: 2783915460
*/
// https://docstore.mik.ua/orelly/webprog/pcook/ch04_26.htm
function pc_next_permutation($p) {
  $size = 9; // Hardcoded set size because remains constant in problem. Equivalent to count($p) - 1
  for ($i = $size - 1; $p[$i] >= $p[$i + 1]; --$i) { }
  if ($i == -1) { return false; }
  for ($j = $size; $p[$j] <= $p[$i]; --$j) { }
  $tmp = $p[$i];
  $p[$i] = $p[$j];
  $p[$j] = $tmp;
  for (++$i, $j = $size; $i < $j; ++$i, --$j) {
    $tmp = $p[$i];
    $p[$i] = $p[$j];
    $p[$j] = $tmp;
  }
  return $p;
}

$set = [0,1,2,3,4,5,6,7,8,9];

for ($i = 1; $i < 1000000; $i++) {
  $set = pc_next_permutation($set);
}

echo implode($set) . PHP_EOL;
