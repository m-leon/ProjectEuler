/*
* Prompt: Find the next triangle number [after 40755] that is also pentagonal and hexagonal.
*
* Execute: javac Problem45.java; java Problem45; rm Problem45.class
*
* Answer: 1533776805
*/

public class Problem45 {
  public static void main(String[] args) {
    for (int i = 2; ; i++) {
      long t = triangular(i);
      if (pentagonal_inverse(t) != 0 && t != 40755) { // 40755 is given in prompt, hardcoded to ignore
        if (hexagonal_inverse(t) != 0) {
          System.out.println(t);
          System.exit(0);
        }
      }
    }
  }

  public static long triangular(long n) {
    return n * (n + 1) / 2;
  }

  // Finds x such that x(3x-1)/2 = given n
  // Uses inverse of pentagonal function:
  //    (1 + sqrt(1+24x)) / 6
  // Returns x if exists, otherwise 0
  public static int pentagonal_inverse(long n) {
    double a = Math.sqrt(24 * n + 1);
    if (a == Math.floor(a)) {
      double b = (a + 1) / 6;
      if (b == Math.floor(b)) {
        return (int) b;
      }
    }
    return 0;
  }

  // Finds x such that x(2x-1) = given n
  // Uses inverse of hexagonal function:
  //    (1 + sqrt(1+8x)) / 4
  // Returns x if exists, otherwise 0
  public static int hexagonal_inverse(long n) {
    double a = Math.sqrt(8 * n  + 1);
    if (a == Math.floor(a)) {
      double b = (a + 1) / 4;
      if (b == Math.floor(b)) {
        return (int) b;
      }
    }
    return 0;
  }
}
