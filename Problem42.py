# Prompt: Using {assets/p042_words.txt}..., how many are triangle words?
#
# Execute: python Problem42.py
#
# Answer: 162
import math

# constant
abc = [0, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U" ,"V", "W", "X", "Y", "Z"]

# Evaluate inverse function of triangle. If result is an integer, n is triangular
def iT(n):
  t = ((math.sqrt(8 * n + 1) - 1) / 2)
  return t == int(t)

def wordToInt(w):
  sum = 0
  for c in w:
    sum += abc.index(c)
  return sum

# Read file into string f
f = open("assets/p042_words.txt", "r")
f = f.read()

# Ignore first and last quote in string
f = f[1:-1]

# Split string into array
f = f.split("\",\"")

# Counter of occurrences of triangular numbers
c = 0
for w in f:
  if iT(wordToInt(w)):
    c += 1

print c
