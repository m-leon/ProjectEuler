# Prompt: Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
#
# Execute: python Problem51.py
#
# Answer: 121313
import sys
import collections

def sieve(limit):
  a = [True] * limit
  a[0] = a[1] = False

  for (i, isprime) in enumerate(a):
    if isprime:
      for n in xrange(i*i, limit, i):
        a[n] = False

  return a

limit = 1000000
primes = sieve(limit)
for n in range(limit):
  if primes[n]:
    s = str(n)
    # Makes the assumption that the most common digit is the commonality between the members of the family
    # Not necessarily true but happens to be true and speeds up the process
    m = collections.Counter(s).most_common(1)[0]
    # Has 3 repeating digits. Arbitrary limit
    if m[1] >= 3:
      familySize = 0 # Loop below will count starting prime
      for d in '0123456789':
        f = int(s.replace(m[0], d))
        if f >= n and primes[f]:
          familySize += 1
      if familySize >= 8:
        print(n)
        sys.exit()
