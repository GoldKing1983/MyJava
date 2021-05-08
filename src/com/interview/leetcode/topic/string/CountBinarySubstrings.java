package com.interview.leetcode.topic.string;

/*
===========================================================Requirement===========================================================
1) Give a binary string s, 
2) return the count of equal occurrence of 0's and 1's, 
3) 0 and 1 should be grouped continuous.
============================================================Example1=============================================================
input : 00110011
    
    01
    0011
    10
    1100
    01
    0011
output: 6

Note: whole of "00110011" has equal number of 0s and 1s, but 0 and 1s are not grouped together.    
============================================================Example2=============================================================    
Input: s = "10101"
Output: 4

"10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
========================================================Solution Approach========================================================
https://www.youtube.com/watch?v=MGPHPadxhtQ
1) Whenever we see current and previous differs. We can form result.
2) 
    
 */
public class CountBinarySubstrings {

  public int countBinarySubstrings(String s) {
    int count = 0, i = 1, prev = 0, curr = 1;
    while (i < s.length()) {
      //11000110
      if (s.charAt(i - 1) != s.charAt(i)) {
        count += Math.min(prev, curr);
        prev = curr;
        curr = 1;
      } else {
        curr++;
      }
      i++;
    }

    return count += Math.min(prev, curr);
  }
}
