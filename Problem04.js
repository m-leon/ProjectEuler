function isPalindrome(num) {
  return num.toString().split('').reverse().join('') == num;
}

max = 0;
for (i = 999; i > 99; i--) {
  for (j = 999; j > 99; j--) {
    product = i * j
    if (isPalindrome(product))
      if (max < product)
        max = product;
  }
}

console.log(max);
