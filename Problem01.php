<?php
/*
* Prompt: Find the sum of all the multiples of 3 or 5 below 1000.
*
* Execute: php Problem01.php
*
* Answer: 233168
*/
$factors = [3, 5];
$sum = 0;

for ($i = 1; $i < 1000; $i++) {
  if (($i % $factors[0] == 0) ||
      ($i % $factors[1] == 0)) {
    $sum += $i;
  }
}
echo $sum . PHP_EOL;
