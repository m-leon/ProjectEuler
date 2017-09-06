<?php
/*
* Prompt: The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
*         There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
*         What 12-digit number do you form by concatenating the three terms in this sequence?
*
* Execute: php Problem49.php
*
* Answer: 296962999629
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

function isPermutation($a, $b) {
  $z = str_split($a);
  $y = str_split($b);
  sort($y);
  sort($z);
  return $y === $z;
}

$primes = sieve(9999);
for ($i = 1000; $i < count($primes); $i++) {
  if ($primes[$i]) {
    $b = $i + 3330;
    $c = $i + 6660;
    if (($primes[$b] && $primes[$c]) &&
        (isPermutation($i, $b) && isPermutation($i, $c))) {
      if (!in_array($i, array(1487, 4187, 8147))) { // Ignore values defined in prompt
        echo $i . $b . $c . PHP_EOL;;
        exit();
      }
    }
  }
}
