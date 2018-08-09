<?php
/*
* Prompt: Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
*
* Execute: php Problem27.php
*
* Answer: -59231
*/
$limit = 2 ** 14; // Arbitrary
$primes = array_fill(0, $limit, true);
$primes[0] = false;
$primes[1] = false;
for ($i = 2; $i < $limit; $i++) {
  if ($primes[$i]) {
    for ($j = $i * $i; $j < $limit; $j += $i) {
      $primes[$j] = false;
    }
  }
}
$p = 0; // Product of coeffecients
$m = 0; // Maximum # of primes from n = 0
for ($a = -1000; $a <= 1000; $a++) {
  for ($b = -1000; $b <= 1000; $b++) {
    $c = 0;
    for ($n = 0; ; $n++) {
      $x = ($n * $n) + ($a * $n) + ($b);
      if ($x > 0 && $primes[$x]) {
        $c++;
      } else {
        break;
      }
    }
    if ($c > $m) {
      $m = $c;
      $p = $a * $b;
    }
  }
}

echo $p . PHP_EOL;
