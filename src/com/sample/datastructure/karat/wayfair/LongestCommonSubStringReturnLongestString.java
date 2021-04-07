package com.sample.datastructure.karat.wayfair;

import java.util.Arrays;

/*

1) Cache the longest point row and col.
2) From longestResult row and col, "traverse back diagonally down to top", till dp[row][col]!=0, because result is
formulated "diagonally from top to bottom"
*/
public class LongestCommonSubStringReturnLongestString {
  // user 0 -- b c d
  // user 1 -- a b c d
  /*
  	0  b c d
  	0  0 0 0
  a 0  0 0 0
  b 0  1 0 0
  c 0  0 2 0
  d	0  0 0 3
  */
  private static String[] findContiguousHistory(String[] input1, String[] input2) {
    int m = input1.length; // abcd
    int n = input2.length; // bcd
    int dp[][] = new int[m + 1][n + 1];
    int longest = -1;
    int row = -1;
    int col = -1;
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (input1[i - 1].equals(input2[j - 1])) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (dp[i][j] > longest) {
            longest = dp[i][j];
            row = i;
            col = j;
          }
        }
      }
    }
    if (longest == -1) return new String[] {};
    String[] result = new String[longest];
    longest--;
    while (dp[row][col] != 0) {
      row--;
      col--;
      result[longest--] = input1[row];
    }
    return result;
  }

  public static void main(String[] argv) {

    String[] input1 = {"a", "b", "c", "d"};
    String[] input2 = {"b", "c", "d"};
    String[] input3 = {"x", "y", "z"};
    String[] input4 = {"a", "y", "x"};

    String[] user0 = {"start", "green", "blue", "pink", "register", "orange", "one/two"};
    String[] user1 = {"start", "pink", "register", "orange", "red", "a"};
    String[] user2 = {"a", "one", "two"};
    String[] user3 = {"pink", "orange", "yellow", "plum", "blue", "tan", "red", "amber",
        "HotRodPink", "CornflowerBlue", "LightGoldenRodYellow", "BritishRacingGreen"};
    String[] user4 = {"pink", "orange", "amber", "BritishRacingGreen", "plum", "blue", "tan", "red",
        "lavender", "HotRodPink", "CornflowerBlue", "LightGoldenRodYellow"};
    String[] user5 = {"a"};


    System.out.println(Arrays.toString(findContiguousHistory(user0, user1)));// => ["pink", "register", "orange"]
    System.out.println(Arrays.toString(findContiguousHistory(user0, user2)));// => [] (empty)
    System.out.println(Arrays.toString(findContiguousHistory(user2, user1)));// => ["a"]
    System.out.println(Arrays.toString(findContiguousHistory(user5, user2)));// => ["a"]
    System.out.println(Arrays.toString(findContiguousHistory(user3, user4)));// => ["plum", "blue", "tan", "red"]
    System.out.println(Arrays.toString(findContiguousHistory(user4, user3)));// => ["plum", "blue", "tan", "red"]

    System.out.println(Arrays.toString(findContiguousHistory(input1, input2)));
    System.out.println(Arrays.toString(findContiguousHistory(input1, input1)));
    System.out.println(Arrays.toString(findContiguousHistory(input2, input1)));
    System.out.println(Arrays.toString(findContiguousHistory(input1, input3)));
    System.out.println(Arrays.toString(findContiguousHistory(input3, input4)));
  }
}
