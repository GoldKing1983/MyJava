package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * https://www.youtube.com/watch?v=NnD96abizww&t=37s
=============================================================================================================================================
Requirement: Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters.
Write a function to calculate the count of the minimum number of deletion and insertion operations.
=============================================================================================================================================
1) Let’s assume len1 is the length of s1 and len2 is the length of s2.
2) Now let’s assume c1 is the length of LCS of the two strings s1 and s2.
3) To transform s1 into s2, we need to delete everything from s1 which is not part of LCS,
so minimum deletions we need to perform from s1 => len1 - c1
4) Similarly, we need to insert everything in s1 which is present in s2 but not part of LCS,
so minimum insertions we need to perform in s1 => len2 - c1
5) So formula is word1.length() - lcs + word2.length() - lcs;
 * ========corner cases========
For "ab" and "cd". result is 4.
So return word1.length() - longestCommonSubSequence + word2.length() - longestCommonSubSequence;
===========Solution is based on Lowest Common subsequence===================
 * 				a || b
 * 				======
 * 				c || current
 *
 * current = a+1 if matches, else Math.max(b,c)

	For Input : Input: text1 = "abcde", text2 = "ace"
		     0  a  b  c  d  e
		=====================
		0 || 0  0  0  0  0  0
		a || 0  1  1  1  1  1
		c || 0  1  1  2  2  2
		e || 0  1  1  2  2  3

=========
"park"
"spake"
Output: 3
=========
"mart"
"karma"
Output: 5
=========
 */
public class DeleteOperationForTwoStringsLongestCommonSubSequenceDP {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int lcs = dp[word1.length()][word2.length()];
    return word1.length() - lcs + word2.length() - lcs;
  }
}
