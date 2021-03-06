/*
* Prompt: The file, poker.txt, contains one-thousand random hands dealt to two players. [...] How many hands does Player 1 win?
*
* Execute: javac Problem54.java; java Problem54; rm Problem54*.class
*
* Answer: 376
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem54 {
  public static String cardValues = "23456789TJQKA";

  public static void main(String[] args) {
    int playerOneWins = 0;
    try {
      File f = new File("assets/p054_poker.txt");
      BufferedReader b = new BufferedReader(new FileReader(f));
      String readLine = "";
      while ((readLine = b.readLine()) != null) {
        if (playerOneWon(readLine))
          playerOneWins++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(playerOneWins);
  }

  public static boolean playerOneWon(String line) {
    // Parse Cards
    String[] p1 = line.substring(0, 14).split(" ");
    String[] p2 = line.substring(15).split(" ");

    Hand playerOne = new Hand();
    Hand playerTwo = new Hand();

    for (int i = 0; i< p1.length; i++) {
      playerOne.addCard(new Card(p1[i]));
    }

    for (int i = 0; i < p2.length; i++) {
      playerTwo.addCard(new Card(p2[i]));
    }

    // Find winner
    if (playerOne.hasRoyalFlush()) {
      return true;
    }
    if (playerTwo.hasRoyalFlush()) {
      return false;
    }
    if (playerOne.hasStraightFlush()) {
      if (playerTwo.hasStraightFlush()) {
        return (playerOne.highCard() > playerTwo.highCard());
      }
      return true;
    }
    if (playerTwo.hasStraightFlush()) {
      return false;
    }
    int p1Value = playerOne.hasFourOfAKind();
    int p2Value = playerTwo.hasFourOfAKind();
    if (p1Value != -1) {
      return (p2Value != -1) ? (p1Value > p2Value) : true;
    }
    if (p2Value != -1) {
      return false;
    }
    if (playerOne.hasFullHouse()) {
      if (playerTwo.hasFullHouse()) {
        return (playerOne.highCard() > playerTwo.highCard());
      }
      return true;
    }
    if (playerTwo.hasFullHouse()) {
      return false;
    }
    if (playerOne.hasFlush()) {
      if (playerTwo.hasFlush()) {
        return (playerOne.highCard() > playerTwo.highCard());
      }
      return true;
    }
    if (playerTwo.hasFlush()) {
      return false;
    }
    if (playerOne.hasStraight()) {
      if (playerTwo.hasStraight()) {
        return (playerOne.highCard() > playerTwo.highCard());
      }
      return true;
    }
    if (playerTwo.hasStraight()) {
      return false;
    }
    p1Value = playerOne.hasThreeOfAKind();
    p2Value = playerTwo.hasThreeOfAKind();
    if (p1Value != -1) {
      return (p2Value != -1) ? (p1Value > p2Value) : true;
    }
    if (p2Value != -1) {
      return false;
    }
    if (playerOne.hasTwoPair()) {
      if (playerTwo.hasTwoPair()) {
        return (playerOne.highCard() > playerTwo.highCard());
      }
      return true;
    }
    if (playerTwo.hasTwoPair()) {
      return false;
    }
    p1Value = playerOne.hasPair();
    p2Value = playerTwo.hasPair();
    if (p1Value != -1) {
      return (p2Value != -1) ? (p1Value > p2Value) : true;
    }
    if (p2Value != -1) {
      return false;
    }
    return (playerOne.highCard() > playerTwo.highCard());
  }

  public static class Hand {
    public List<Card> cards = new ArrayList<Card>();

    public void addCard(Card c) {
      cards.add(c);
      Collections.sort(cards);
    }

    public int highCard() {
      int highValue = -1;
      for (Card c : cards) {
        if (c.value > highValue) {
          highValue = c.value;
        }
      }
      return highValue;
    }

    public boolean hasFlush() {
      char suit = '\u0000';
      for (Card c : cards) {
        if (suit == '\u0000') {
          suit = c.suit;
        }
        // Found non-continuous suit, not a flush
        if (suit != c.suit) {
          return false;
        }
      }
      return true;
    }

    // Cards assumed to be in order of value at beginning
    public boolean hasStraight() {
      int n = -1; // Value of previous card
      for (Card c : cards) {
        if (n == -1) {
          n = c.value;
        } else {
          // Found non-continous value, not a straight
          if (c.value - n != 1) {
            return false;
          }
          n = c.value;
        }
      }
      return true;
    }

    public boolean hasStraightFlush() {
      return (hasFlush() && hasStraight());
    }

    // Check if straight flush && first card in straight is 10
    public boolean hasRoyalFlush() {
      return hasStraightFlush() && (cards.get(0).value == 8);
    }

    // Convenience method for no necessary distinct value
    private int hasOfaKind(int n) {
      return hasOfaKind(n, -1);
    }

    // Cards are sorted by value, it can be assumed that if they are not consecutive in list, they are not present
    private int hasOfaKind(int n, int distinctFrom) {
      int v = -1; // Value that is being counted
      int count = 0; // # of consecutive values
      for (Card c : cards)  {
        if (c.value == distinctFrom) {
          continue;
        }
        // Found new value, restart count
        if (c.value != v) {
          count = 1;
          v = c.value;
        } else {
          count += 1;
        }
        // Quit counting when limit met
        if (count >= n) {
          return v;
        }
      }
      return -1;
    }

    public int hasFourOfAKind() {
      return hasOfaKind(4);
    }

    public int hasThreeOfAKind() {
      return hasOfaKind(3);
    }

    public boolean hasFullHouse() {
      int threeOfAKind = hasOfaKind(3);
      if (threeOfAKind != -1) {
        return (hasOfaKind(2, threeOfAKind) != -1);
      }
      return false;
    }

    public boolean hasTwoPair() {
      int firstPair = hasOfaKind(2);
      if (firstPair != -1) {
        return (hasOfaKind(2, firstPair) != -1);
      }
      return false;
    }

    public int hasPair() {
      return hasOfaKind(2);
    }
  }

  public static class Card implements Comparable<Card> {
    public int value;
    public char suit;

    public Card(String c) {
      this.value = cardValues.indexOf(c.charAt(0));
      this.suit = c.charAt(1);
    }

    @Override
    public int compareTo(Card other) {
      return Integer.compare(this.value, other.value);
    }
  }
}
