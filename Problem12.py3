# Prompt: What is the value of the first triangle number to have over five hundred divisors?
#
# Execute: python3 Problem12.py3
#
# Answer: 76576500
import math

def count_divsors(num):
  c = 0
  for d in range(1, math.ceil(math.sqrt(num)) + 1):
    if num % d == 0:
      c += 2
    if d * d == num:
      c -= 1
  return c

def triangle(n):
  triangular = 0
  for i in range(1, n + 1):
    triangular += i
  return triangular

n = 1
while (count_divsors(triangle(n)) < 500):
  n += 1

print(triangle(n))
