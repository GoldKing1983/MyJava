package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/split-a-string-in-balanced-strings/
======================================================Requirement================================================================
Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.
======================================================Example1===================================================================
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
==================================================Solution Approach==============================================================
1) Iterate each char in inputString.
2) If 'R' increment count, else decrement count.
3) If count==0, it is balanced. Increment resultCount.
 */
public class SplitAStringInBalancedStrings {

  public int balancedStringSplit(String s) {
    int count = 0;
    int resultCount = 0;
    for (char c : s.toCharArray()) {
      count = c == 'R' ? (count + 1) : (count - 1);
      if (count == 0) resultCount++;
    }
    return resultCount;
  }
}
