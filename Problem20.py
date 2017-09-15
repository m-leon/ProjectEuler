# Prompt: Find the sum of the digits in the number 100!
#
# Execute: python Problem20.py
#
# Answer: 648
f = 1
for i in range(1, 101):
  f *= i

s = 0
for i in str(f):
  s += int(i)

print(s)
