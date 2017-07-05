<?php
$factors = [3, 5];
$sum = 0;

for ($i = 1; $i < 1000; $i++) {
  if (($i % $factors[0] == 0) ||
      ($i % $factors[1] == 0)) {
    $sum += $i;
  }
}
echo $sum;
