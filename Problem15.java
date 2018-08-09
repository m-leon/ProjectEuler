/*
* Prompt: How many ... routes are there through a 20×20 grid [only being able to move to the right and down]?
*
* Execute: javac Problem15.java; java Problem15; rm Problem15.class
*
* Answer: 137846528820
*/
public class Problem15 {
  // https://en.wikipedia.org/wiki/Binomial_coefficient
  public static void main(String[] args) {
    int gridSize = 20;
    long paths = 1;
    for (int i = 0; i < gridSize; i++) {
      paths *= (2 * gridSize) - i;
      paths /= i + 1;
    }
    System.out.println(paths);
  }
}
