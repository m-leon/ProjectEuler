/*
* Prompt: What is the largest prime factor of the number 600851475143?
*
* Execute: javac Problem03.java; java Problem03; rm Problem03.class
*
* Answer: 6857
*/
import java.math.BigInteger;

// From http://www.s-anand.net/euler.html
public class Problem03 {
  public static void main(String[] args) {
    BigInteger n = new BigInteger("600851475143");
    BigInteger i = new BigInteger("2");
    while (i.multiply(i).compareTo(n) < 0) {
      while (n.mod(i) == BigInteger.ZERO) {
        n = n.divide(i);
      }
      i = i.add(BigInteger.ONE);
    }
    System.out.println(n);
  }
}
