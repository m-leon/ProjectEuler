<?php
/*
* Prompt: If p is the perimeter of a right angle triangle with integral length sides, for which value of p ≤ 1000, is the number of solutions maximised?
*
* Execute: php Problem39.php
*
* Answer: 840
*/
/*
 * Given
 *   a^2 + b^2 = c^2
 *   P = a + b + c
 * Therefore
 *   c = P - a - b
 *   a^2 + b^2 = (P - a - b)^2
 *     = p^2 + a^2 + b^2 -2pa - 2pb + 2ab
 *   b = (p^2 - 2pa) / (2p - 2a)
 */
$n = 0;
$m = 0;
for ($p = 2; $p <= 1000; $p += 2) {
  $c = 0;
  for ($a = 2; $a < ($p / 3); $a++) {
    if ($p * ($p - 2 * $a) % (2 * ($p - $a)) == 0) {
      $c++;
    }
  }
  if ($c > $m) {
    $m = $c;
    $n = $p;
  }
}

echo $n . PHP_EOL;
