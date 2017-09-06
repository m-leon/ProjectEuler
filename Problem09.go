// Prompt: There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product a*b*c.
//
// Execute: go run Problem09.go
//
// Answer: 31875000
package main

import ("fmt"
        "math")

func main() {
  for a := 1; a < 500; a++ {
    for b := a + 1; b < 1000; b++ {
      c := 1000 - a - b;
      if math.Pow(float64(a), 2) + math.Pow(float64(b), 2) == math.Pow(float64(c), 2) {
        fmt.Println(a * b * c)
        return
      }
    }
  }
}
