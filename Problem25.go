// Prompt: What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
//
// Execute: go run Problem25.go
//
// Answer: 4782
package main

import ("fmt"
        "math/big")

func main() {
  a := big.NewInt(1)
  b := big.NewInt(1)
  i := 1

  var limit big.Int
  limit.Exp(big.NewInt(10), big.NewInt(999), nil)

  for a.Cmp(&limit) < 0 {
    i += 1
    a.Add(a, b)
    a, b = b, a
  }
  fmt.Println(i)
}
