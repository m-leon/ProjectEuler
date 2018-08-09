# Prompt: Find the sum of all 0-9 pandigital numbers whose:
#           digits 2-4 {d(2)...d(4)} are divisible by 2
#           d(3)...d(5) are divisible by 3
#           d(4)...d(6) are divisible by 5
#           d(5)...d(7) are divisible by 7
#           d(6)...d(8) are divisible by 11
#           d(7)...d(9) are divisible by 13
#           d(8)...d(10) are divisible by 17
#
# Execute: python Problem43.py
#
# Answer: 16695334890
def complies(n):
  n = str(n)

  # Explicit tests
  # Explanation:
  #   d(4).d(5).d(6) must be divisible by 5
  #     Therefore d(6) must be 0 or 5
  #   d(6).d(7).d(8) must be divisible by 11
  #     Therefore d(6) may not be 0
  #     Therefore d(6).d(7).d(8) must be within known multiples of 11 between 500-600 without digit repeats
  #       d(6).d(7).d(8) must be within {506, 517, 528, 539, 561, 572, 583, 594}
  #   d(7).d(8).d(9) must be divisible by 13
  #     Therefore we can further limit the set
  #       d(6)...d(9) must be within {5286, 5390, 5728, 5832}
  #   d(8).d(9).d(10) must be divisible by 17
  #     Therefore we can further limit the set
  #       d(6)...d(10) must be within {52867, 53901, 57289}
  #   d(5).d(6).d(7) must be divisible by 7
  #     Therefore we can further limit the set
  #       d(5)...d(10) must be within {952867, 357289}
  #   d(2).d(3).d(4) must be divisible by 2
  #     Therefore d(4) must be even
  #       d(4)...d(10) must be within {0952867, 4952867, 0357289, 4357289, 6357289}
  #   d(3).d(4).d(5) must be divisible by 3
  #     Therefore we can further limit our set
  #       d(3)...d(10) must be within {30952867, 60357289, 06357289}
  if n[2:10] not in ['30952867', '60357289', '06357289']:
    return False

  # Brute force tests
  # Skip test d(2).d(3).d(4) % 2 because of explicit test above
  # Skip test d(3).d(4).d(5) % 3 because of explicit test above
  # Skip test d(4).d(5).d(6) % 5 because of explicit test above
  if int(n[4:7]) % 7 != 0:
    return False
  # Skip test d(5).d(6).d(7) % 11 because of explicit test above
  # Skip test d(6).d(7).d(8) % 13 because of explicit test above
  # Skip test d(7).d(8).d(9) % 17 because of explicit test above
  return True

# Reduced the known set of compliant pandigital numbers to a subset for d(3)...d(10) that doesn't contain 1 or 4
#   Therefore d(1) and d(2) must be either 1 or 4

# Programmatically generating permuations is resource expensive and the possible set to 6 integers
# Simply add known compliant integers rather than spend the resources to generate the set programmatically
print(1430952867 + 1460357289 + 1406357289 + 4130952867 + 4160357289 + 4106357289)
