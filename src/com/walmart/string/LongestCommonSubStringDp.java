package com.walmart.string;

/*
https://en.wikipedia.org/wiki/Longest_common_substring_problem

	Can be solved by bruteforce or suffix tree or DP. Below is DP approach
==============BruteForce==============
 1) Take all combination(continuous only) of search string and put it in Set.
 Ex: a b c --> combination would be--> a,b,c,ab,bc,abc
 (Note:"ac" will not come. Because it is discontinuous)
 2) For every substring, verify it exists in input string Ex: a b d.
============DP========================
	String X = "ABC";
	String Y = "ABD";

	  0 A B C
      =======
 0 || 0 0 0 0
 A || 0
 B || 0
 D || 0

	  0 A B C
      =======
 0 || 0 0 0 0
 A || 0 1 0 0
 B || 0 0 2 0
 D || 0 0 0 0

 1) The first row and first column entries, says for 0 "search string" for "input string" output is 0.
 2) If character matches, then pick value diagonally and add 1 to it. Else 0.
 				a ||
 				======
 				  || current (current = a+1 if matches, else 0

 ====Logically if a column matches and next column don't matches. we put 0. Because it is discontinued.=======
 ====But in Longest Common Sub Sequence we pick previous value. Because if discontinued, we take previous answer=========

*/
public class LongestCommonSubStringDp {
  public int lcs(char[] x, char[] y) {
    int[][] dp = new int[x.length + 1][y.length + 1];
    int result = 0;

    for (int row = 1; row <= x.length; row++) {
      for (int col = 1; col <= y.length; col++) {
        if (x[row - 1] == y[col - 1]) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
          result = Integer.max(result, dp[row][col]);
        }
      }
    }
    return result;
  }
}
