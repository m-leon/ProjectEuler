# Prompt: By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
#
# Execute: python Problem02.py
#
# Answer: 4613732
a, b = 1, 2
sum = 0
while (a < 4000000):
  a, b = b, a + b
  if (a % 2 == 0):
    sum += a
print sum
