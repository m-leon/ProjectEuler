<?php
/*
* Prompt: Using {assets/p059_cipher.txt}, a file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
*
* Execute: php Problem59.php
*
* Answer: 107359
*/
$cipher = file_get_contents('assets/p059_cipher.txt');
$cipher = trim($cipher);
$cipher = explode(',', $cipher);

function encrypt($text, $key) {
  $decrypted = []; // Decrypted Text
  $i = 0; // Index on key array
  foreach ($text as $c) {
    $decrypted[] = $c ^ $key[$i];
    $i++;
    if (count($key) <= $i) {
      $i = 0;
    }
  }

  return $decrypted;
}

function toASCIIArray($input) {
  $array = [];
  foreach (str_split($input) as $c) {
    $array[] = ord($c);
  }
  return $array;
}

function toString($input) {
  $str = "";
  foreach ($input as $c) {
    $str .= chr($c);
  }
  return $str;
}

$pass = "aaa";
while (strlen($pass) < 4) {
  $key = toASCIIArray($pass);
  $dec = encrypt($cipher, $key);
  $str = toString($dec);
  // "English" dectector
  if (!preg_match("/[^A-Za-z0-9 !'(),.;]/", $str)) {
    echo array_sum($dec) . PHP_EOL;
    exit;
  }
  $pass++;
}
