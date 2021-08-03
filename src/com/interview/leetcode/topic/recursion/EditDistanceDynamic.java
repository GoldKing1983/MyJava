package com.interview.leetcode.topic.recursion;

/*
https://leetcode.com/problems/edit-distance/description/
https://www.youtube.com/watch?v=We3YDTzNXEk
===========================================================Requirement===========================================================
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
==============================================================Solution Approach==============================================================
1) Fill first row with 0,1,2,3 to n and first column with 0,1,2,3 to n.
2) if match found pick diagonal
3) else minimum of "left, top and diagonal" +1
4) return bottom right most diagonal.
==============================================================Data Flow Analysis - Both Same================================================
Input: word1 = "a", word2 = "a" Output=0
			   0 a
			   =======
		  0	|| 0 1
		  a	|| 1 0
==============================================================Data Flow Analysis - Insertion=================================================
Input: word1 = "a", word2 = "abc" Output=2
			   0 a b c
			   =======
		  0	|| 0 1 2 3
		  a	|| 1 0 1 2
==============================================================Data Flow Analysis - Remove======================================================
Input: word1 = "abc", word2 = "ac" Output=1
			   0 a c
			   =====
		  0	|| 0 1 2
		  a	|| 1 0 1
		  b	|| 2 1 1
		  c	|| 3 2 1
==============================================================Data Flow Analysis - Replace=============================================
Input: word1 = "adc", word2 = "abc" Output=2
			   0 a b c
			   ==========
		  0	|| 0 1 2 3
		  a	|| 1 0 1 2
		  d	|| 2 1 1 2
		  c	|| 3 2 2 1
==============================================================Data Flow Analysis - All operations===============================================
Input: word1 = "horse", word2 = "ros" Output: 3
			   0 r o s
			   =======
		  0	|| 0 1 2 3
		  h	|| 1 1 2 3
		  o	|| 2 2 1 2
		  r	|| 3 2 2 2
		  s	|| 4 3 3 2
		  e	|| 5 4 4 3

		  a || b
		  ======
		  c || current

	if match -> current=a
	else current=min(a,b,c)+1

 */
public class EditDistanceDynamic {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];

    // Assume if s2 is empty, we can insert/remove all the characters of s1
    for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;

    // Assume if s1 is empty,  we can insert/remove all the characters of s2
    for (int i = 0; i <= word2.length(); i++) dp[0][i] = i;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
