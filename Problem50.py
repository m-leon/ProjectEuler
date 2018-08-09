# Prompt: Which prime, below one-million, can be written as the sum of the most consecutive primes?
#
# Execute: python Problem50.py
#
# Answer: 997651
def sieve(limit):
  a = [True] * limit
  a[0] = a[1] = False

  for (i, isprime) in enumerate(a):
    if isprime:
      for n in xrange(i*i, limit, i):
        a[n] = False

  return a

limit = 1000000
primes = sieve(limit + 1)
sums = []
maxSum = 0
maxPrimes = 0
for n in range(limit):
  if primes[n]:
    # Add to all existing sums
    for sum in sums:
      sum[0] += n
      sum[1] += 1
      # Remove any sums exceeding limit
      if sum[0] > limit:
        sums.remove(sum)
        continue
      # If sum is prime, check against existing maxes
      if primes[sum[0]] and sum[1] > maxPrimes:
        maxSum = sum[0]
        maxPrimes = sum[1]

    # Add new sum starting at n to check
    sums.append([n, 1])

print maxSum
