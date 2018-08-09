/*
* Prompt: What is the largest n-digit pandigital prime that exists?
*
* Execute: javac Problem41.java; java Problem41; rm Problem41.class
*
* Answer: 7652413
*/
import java.util.Arrays;

public class Problem41 {
  private static final char[] pandigital = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

  public static void main(String[] args) {
    int limit = 9999999; // Arbitrary
    boolean[] primes = sieve(limit);
    int largePandigitalPrime = 0;

    for (int i = 0; i < limit; i++)
      if (primes[i] && isPandigital(i))
        largePandigitalPrime = i;

    System.out.println(largePandigitalPrime);
  }

  private static boolean[] sieve(int n) {
    boolean primes[] = new boolean[n];
    Arrays.fill(primes, true);

    for (int p = 2; p * p < n; p++)
      if (primes[p])
        for (int i = p * 2; i < n; i += p)
          primes[i] = false;

    return primes;
  }

  private static boolean isPandigital(int n) {
    char[] c = Integer.toString(n).toCharArray();
    Arrays.sort(c);

    for (int i = 0; i < c.length; i++)
      if (c[i] != pandigital[i])
        return false;

    return true;
  }
}
