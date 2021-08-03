package com.walmart.string;

/*
https://leetcode.com/problems/longest-common-subsequence/
https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N

Input: text1 = "abcde",
	   text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Input: text1 = "abc",
	   text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Input: text1 = "abc",
       text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
=============================================Initial Thinking====================================================================
Similar to "GroupSum6" and not "GroupSum".
        i.e GroupSum ==> Go in 2path(left&right) vs GroupSum6 ==> Go in 1path If 6 Else Go in 2path(left&right)
==========================================Solution Approach Dp - O(n^2)=================================================
See Also LongestPalindromicSubsequenceRecursion

1) Compare inputString and patternString characters from 0thIndex.
2) If both matches. increment both index. Add +1. recurse.
3) Else left = increment inputIndex recur, right = increment patternIndex recur. return Math.max(left, right);
=======================================================Data Flow Analysis========================================================
"alalg"
"alg"
Important Note: Here output is formed by index0,1,4 and not by index2,3,4
output: 3

                                              root
                                               |    
                                              a,a
                                               |
                                              l,l
                                               |
                                              a,g
                                              / \
                                            l,g
                                            /  \
                                          g,g  
=======================================================Data Flow Analysis========================================================
"alalg"
"albcg"
Important Note: Here output is formed by index0,1,4 and not by index2,3,4
output: 3

                                              root
                                               |    
                                              a,a
                                               |
                                              l,l
                                               |     
                                              a,b      
                                            /     \
                                          a,c     b,l   
                                          /          \
                                        a,g          b,g
                                             
*/
public class LongestCommonSubsequenceRecursion {

  public int longestCommonSubsequence(String input, String pattern) {
    return longestCommonSubsequence(input.toCharArray(), pattern.toCharArray(), 0, 0);
  }

  public static int longestCommonSubsequence(char[] input, char[] pattern, int inputIndex,
      int patternIndex) {
    if (inputIndex == input.length || patternIndex == pattern.length) return 0;
    if (input[inputIndex] == pattern[patternIndex])
      return 1 + longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex + 1);

    int left = longestCommonSubsequence(input, pattern, inputIndex, patternIndex + 1);
    int right = longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex);
    return Math.max(left, right);
  }
}
