package com.interview.leetcode.topic.string;

/*
https://binarysearch.com/problems/Removing-Parentheses
===========================================================Requirement===========================================================
1) Given a string of parentheses s.
2) Return the minimum number of parentheses(can be open or close) to be removed to make the string balanced.

============================================================Example1=============================================================
Input : s = "()())()"
Output : 1
Explanation : We can remove the ")" at index 4 to make it balanced.

============================================================Example2=============================================================
Input : s = ")("
Output : 2
Explanation: We must remove all the parentheses.
========================================================Solution Approach========================================================
1) When a closeParantheses comes, if openCount<=0 .. then increment resultCount.
                                  else openCount--
=================================================================================================================================

 */
public class RemovingParentheses {
  public int solve(String s) {
    int openCount = 0;
    int resultCount = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        openCount++;
      } else {
        if (openCount > 0) openCount--;
        else resultCount++;
      }
    }
    return resultCount + openCount;
  }
}
