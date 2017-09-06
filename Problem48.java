/*
* Prompt: Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
*
* Execute: javac Problem48.java; java Problem48; rm Problem48.class
*
* Answer: 9110846700
*/
import java.math.BigInteger;

public class Problem48 {
  public static void main(String[] args) {
    System.out.println(solveWithMod());
  }

  public static String solveWithBigInt() {
    BigInteger sum = BigInteger.ZERO;
    for (int i = 1; i <= 1000; i++) {
      sum = sum.add(BigInteger.valueOf(i).pow(i));
    }
    String result = sum.toString();
    return result.substring(result.length() - 10);
  }

  public static long reduce(long n) {
    /*while (n > 10000000000L) { // Slower than mod
      n -= 10000000000L;
    }
    return n;*/
    return n % 10000000000L;
  }

  public static String solveWithMod() {
    long sum = 0;
    for (int i = 1; i < 1000; i++) {
      long n = i; // Last 10 digits of i^i
      for (int j = 1; j < i; j++) {
        n = reduce(n * i);
      }
      sum = reduce(sum + n);
    }

    return Long.toString(sum);
  }
}
