<?php
/*
* Prompt: What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*
* Execute: php Problem46.php
*
* Answer: 5777
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

function isTwiceSquare($n) {
  return floor(sqrt($n/2)) == sqrt($n/2);
}

$primes = sieve(10000); // 10000 is arbitrary. Needs to be greater than the solution
$found = false;
for ($i = 3; true; $i+=2) {
  $found = true;
  for ($j = 0; $j <= $i; $j++) {
    if ($primes[$j]) {
      if (isTwiceSquare($i - $j)) {
        $found = false;
      }
    }
  }
  if ($found) {
    echo $i . PHP_EOL;
    exit();
  }
}
