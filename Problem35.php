<?php
/*
* Prompt: How many circular primes are there below one million?
*
* Execute: php Problem35.php
*
* Answer: 55
*/
function sieve($limit) {
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
  return $primes;
}

function digitRotations($n) {
  $r = [];
  while (true) {
    $n = rotate($n);
    if (in_array($n, $r)) {
      break;
    }
    $r[] = (int) $n;
  }
  return $r;
}

function rotate($n) {
  return substr($n, 1) . substr($n, 0, 1);
}

$limit = 1000000;
$primes = sieve($limit);

$c = 0;

for ($i = 0; $i < $limit; $i++) {
  if ($primes[$i]) {
    $r = digitRotations($i);
    foreach ($r as $d)
      if (!$primes[$d])
        continue 2;
    $c++;
  }
}

echo $c . PHP_EOL;
