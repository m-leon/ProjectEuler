/*
* Prompt: What is the total of all the name scores in the file [p022_names.txt]?
*
* Execute: javac Problem22.java; java Problem22; rm Problem22.class
*
* Answer: 871198282
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Problem22 {
  public static String values = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static void main(String[] args) {
    String raw = "";
    try {
      raw = new String(Files.readAllBytes(Paths.get("assets/p022_names.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    int total = 0;
    String[] names = raw.substring(1, raw.length() - 1).split("\",\"");
    Arrays.sort(names);
    for (int i = 0; i < names.length; i++) {
      int score = 0;
      for (int j = 0; j < names[i].length(); j++) {
        score += values.indexOf(names[i].charAt(j));
      }
      total += (i + 1) * score;
    }
    System.out.println(total);
  }
}
