<?php
/*
* Prompt: Find the simplified denominator of the fraction obtained by multiplying the 4 non-trivially simplified fractions with two digits and a value less than 1
* (See https://projecteuler.net/problem=33)
*
* Execute: php Problem33.php
*
* Answer: 100
*/
function gcd($a, $b) {
  return ($a % $b) ? gcd($b, $a % $b) : $b;
}

$product_n = 1;
$product_d = 1;

for ($d = 11; $d < 100; $d++) {
  for ($n = $d - 1; $n >= 10; $n--) {
    if ($n % 10 === 0 || $d % 10 === 0) continue;
    $n_split = str_split((string) $n);
    $d_split = str_split((string) $d);
    $common = array_unique(array_intersect($n_split, $d_split));
    foreach ($common as $c) {
      $a = (int) implode(array_diff($n_split, [$c]));
      $b = (int) implode(array_diff($d_split, [$c]));
      if ($b != 0 && $n / $d === $a / $b) {
        $product_n *= $a;
        $product_d *= $b;
      }
    }
  }
}

$gcd = gcd($product_n, $product_d);
$simplified_d = $product_d / $gcd;
echo $simplified_d . PHP_EOL;
