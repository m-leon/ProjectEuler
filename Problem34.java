/*
* Prompt: Find the sum of all numbers which are equal to the sum of the factorial of their digits.
*
* Execute: javac Problem34.java; java Problem34; rm Problem34.class
*
* Answer: 40730
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem34 {
  static Map<Integer, Integer> factorials = new HashMap<Integer, Integer>();

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 3; i < 50000; i++) {
      int[] digits = getDigits(i);
      int sumOfFactorialOfDigits = 0;
      for (int d : digits) {
        sumOfFactorialOfDigits += getFactorial(d);
      }
      if (i == sumOfFactorialOfDigits) {
        sum += i;
      }
    }
    System.out.println(sum);
  }

  static int[] getDigits(int n) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    while (n > 0) {
        digits.add(n % 10);
        n /= 10;
    }
    int[] dig = new int[digits.size()];
    for (int i = 0; i < digits.size(); i++) {
      dig[i] = digits.get(i);
    }
    return dig;
  }

  static int getFactorial(int n) {
    Integer f = factorials.get(n);
    if (f == null) {
      f = factorial(n);
      factorials.put(n, f);
    }
    return f;
  }

  static int factorial(int n) {
    int f = 1;
    for (int i = n; i > 0; i--) {
      f *= i;
    }
    return f;
  }
}
