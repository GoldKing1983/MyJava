package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * https://www.youtube.com/watch?v=NnD96abizww&t=37s
===========================================================Requirement===========================================================
1) Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
2) Write a function to calculate the count of the minimum number of deletion and insertion operations.
============================================================Example1=============================================================
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: lcs = 2. 3-2 + 3-2 = 2 
============================================================Example1=============================================================
Input: word1 = "leetcode", word2 = "etco"
Output: 4
Explanation: lcs = 2. 8-4 + 4-4 = 4
============================================================Example1=============================================================
Input: word1 = "ab", word2 = "cd"
Output: 4
Explanation: lcs = 0. 2-0 + 2-0 = 4
========================================================Solution Approach========================================================
1) By analyzing the input, if I find lcs and remove lcs from word1 and word2... which is the answer.
2) do lcs. return word1.length() - lcs + word2.length() - lcs.
3) Hint:Don't think as genius and try one dimensioanl dp, there are so many corner cases and no one has solved with 1 dimensional
============================================================Formula==============================================================
 				a || b
 				======
 				c || currentPoint

    currentPoint = a+1 if matches, else Math.max(b,c)
=======================================================Data Flow Analysis========================================================
	word1 = "abcde", word2 = "ace"... output: 2
		      0   a   b   c   d   e
		0 ||  0   0   0   0   0   0
        ===========================
		a ||  0   1   1   1   1   1
		c ||  0   1   1   2   2   2
		e ||  0   1   1   2   2   3
=======================================================Data Flow Analysis========================================================    
    word1 = "leetcode", word2 = "etco"... output: 4
              l   e   e   t   c   o   d   e
        0 ||  0   0   0   0   0   0   0   0
        ===================================
     e  0 ||  0   1   1   1   1   1   1   1   
     t  0 ||  0   1   1   2   2   2   2   2
     c  0 ||  0   1   1   2   3   3   3   3
     o  0 ||  0   1   1   2   3   4   4   4  

 */
public class DeleteOperationForTwoStringsLongestCommonSubSequenceDP {
  public int minDistance(String word1, String word2) {
    int lcs = lcs(word1, word2);
    return word1.length() - lcs + word2.length() - lcs;
  }

  private int lcs(final String word1, final String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 1; i <= word1.length(); i++) {
      char c1 = word1.charAt(i - 1);
      for (int j = 1; j <= word2.length(); j++) {
        char c2 = word2.charAt(j - 1);
        if (c1 == c2) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
