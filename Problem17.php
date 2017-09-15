<?php
/*
* Prompt: If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
*
* Execute: php Problem17.php
*
* Answer: 21124
*
* Notes: Requires php-intl enabled
*/
$f = new \NumberFormatter("en", \NumberFormatter::SPELLOUT);
$n = 0;
for ($i = 1; $i <= 1000; $i++) {
  $s = $f->format($i);
  $s = str_replace(array(" ", "-"), "", $s);;
  $n += strlen($s);
  // SPELLOUT doesn't include "and" so we add 3 where and should be
  // Note: Logic below breaks in a longer range
  if ($i > 100 && $i % 100 != 0) {
    $n += 3;
  }
}
echo $n . PHP_EOL;
