<?php
/*
* Prompt: How many different ways can £2 be made using any number of coins?
*
* Execute: php Problem31.php
*
* Answer: 73682
*/
$coins = [
  1,
  2,
  5,
  10,
  20,
  50,
  100,
  200
];

$target = 200;

$ways = array_fill(0, $target + 1, 0);
$ways[0] = 1;
for ($i = 0; $i < count($coins); $i++) {
  for ($j = $coins[$i]; $j <= $target; $j++) {
    $ways[$j] += $ways[$j - $coins[$i]];
  }
}

echo $ways[$target] . PHP_EOL;
