/*
* Prompt: Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?
*
* Execute: javac Problem44.java; java Problem44; rm Problem44.class
*
* Answer: 5482660
*/

public class Problem44 {
  public static void main(String[] args) {
    long[] p = new long[9999]; // Arbitrary array size
    for (int k = 1; k < p.length; k++) {
      p[k] = pentagonal(k);
      for (int j = k; j > 0; j--) {
        if (isPentagonal(p[j] + p[k]) && isPentagonal(p[k] - p[j])) {
          System.out.println(p[k] - p[j]);
          System.exit(0);
        }
      }
    }
  }

  public static long pentagonal(int n) {
    return (n * ((3 * n) - 1)) / 2;
  }

  // Determines whether given n is pentagonal
  public static boolean isPentagonal(long n) {
    double a = Math.sqrt(24 * n + 1);
    if (a == Math.floor(a)) {
      double b = (a + 1) / 6;
      return b == Math.floor(b);
    }
    return false;
  }
}
