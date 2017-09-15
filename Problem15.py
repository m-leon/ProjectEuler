# Prompt: What is the sum of the digits of the number 2^(1000)?
#
# Execute: python Problem13.py
#
# Answer: 1366
n = 2
for i in range(1, 1000):
  n *= 2

sum = 0
for i in str(n):
  sum += int(i)

print sum
