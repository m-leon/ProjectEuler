# Prompt: How many Lychrel numbers are there below ten-thousand?
#
# Execute: python Problem55.py
#
# Answer: 249
def isPalindrome(n):
  n = str(n)
  return n == n[::-1]

l = 0
for i in range(1, 10000):
  r = str(i)[::-1]
  s = i + int(r)
  c = 1
  while not isPalindrome(s):
    if c > 50:
      l += 1
      break

    n = s
    r = str(n)[::-1]
    s = n + int(r)
    c += 1

print(l)
