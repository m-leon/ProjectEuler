/*
* Prompt: How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
*
* Execute: javac Problem53.java; java Problem53; rm Problem53.class
*
* Answer: 4075
*/
import java.math.BigInteger;

public class Problem53 {
  public static BigInteger[] factorials = new BigInteger[101];

  public static void main(String[] args) {
    BigInteger limit = BigInteger.valueOf(1000000);

    // Calculate factorials from 0-100
    factorials[0] = BigInteger.valueOf(1);
    for (int i = 1; i <= 100; i++) {
      factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
    }

    int count = 0;
    for (int i = 1; i <= 100; i++) {
      for (int j = i; j > 0; j--) {
        if (c(i, j).compareTo(limit) > 0) {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  public static BigInteger c(int n, int r) {
    BigInteger numerator = factorials[n];
    BigInteger denominator = factorials[r].multiply(factorials[n - r]);
    return numerator.divide(denominator);
  }
}
