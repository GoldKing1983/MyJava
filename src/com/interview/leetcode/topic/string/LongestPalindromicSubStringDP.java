package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/longest-palindromic-substring/
In above we need to return the string itself. Here we are returning length.

=======Need to do more analysis=======
=======================Solution Approach - Time Complexity: O(n^2)===============================================================
=================================================================================================================================

input:"babad"
                  
col moves from leftToRight
row moves from rightToLeft                  
                  
=====Starting col====0
Comparing b b
=====Starting col====1
Comparing a a
Comparing a b
=====Starting col====2
Comparing b b
Comparing b a
Comparing b b
=====Starting col====3
Comparing a a
Comparing a b
Comparing a a
Comparing a b
=====Starting col====4
Comparing d d
Comparing d a
Comparing d b
Comparing d a
Comparing d b
 
    
 */
public class LongestPalindromicSubStringDP {

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return s;
    int n = s.length();
    //substring(i,j) is panlidrome
    boolean[][] dp = new boolean[n][n];
    String res = null;
    //[j, i]
    for (int col = 0; col < n; col++) {
      for (int row = col; row >= 0; row--) {
        if (s.charAt(col) == s.charAt(row) && (col - row < 2 || dp[row + 1][col - 1])) {
          dp[row][col] = true;
          if (res == null || col - row + 1 > res.length()) {
            res = s.substring(row, col + 1);
          }
        }
      }
    }
    return res;
  }
}
