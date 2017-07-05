# Prompt: Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
#
# Execute: perl Problem06.pl
#
# Answer: 25164150
my $sumofsquares = 0;
my $squareofsums = 0;

for my $i (0..100) {
  $sumofsquares += $i * $i;
  $squareofsums += $i;
}

$squareofsums *= $squareofsums;

print $squareofsums - $sumofsquares . "\n";
