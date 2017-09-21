/*
* Prompt: What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
*
* Execute: javac Problem28.java; java Problem28; rm Problem28.class
*
* Answer: 669171001
*/
public class Problem28 {
  public static void main(String[] args) {
    int sum = 1; // Total sum, initiate at 1 for beginning level of loop
    int n = 1; // Value at each point on spiral
    int size = 1001; // Known from prompt
    for (int i = 0; i < (size - 1) / 2; i++) { // Iterate over each level of spiral
      for (int j = 0; j < 4; j++) { // Iterate over each corner of the level
        n +=  2 * (i + 1);
        sum += n;
      }
    }
    System.out.println(sum);
  }
}
