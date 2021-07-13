package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', find the length of the
longest valid (well-formed) parentheses substring.

")()())"  --> 4
valid : [false, true, true, true, true, false]

"()(()()" --> 4
valid: [true, true, false, true, true, true, true]

"()(())"  --> 6
valid: [true, true, true, true, true, true]

========================================================Solution Approach========================================================
1) Stack manages the OpenParenthesesIndex...
2) Ex:   ((()))
   stack=012
   valid=fff

3) On processing index3, we set true for index2 and index3
4) On processing index4, we set true for index1 and index4
5) On processing index3, we set true for index0 and index5   
       
 */
public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    int n = s.length();
    boolean[] valid = new boolean[n];

    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') stack.push(i);
      else if (!stack.isEmpty()) {
        valid[i] = true;
        valid[stack.pop()] = true;
      }
    }

    return longest(valid);
  }

  // Collect the longest true
  private int longest(boolean[] valid) {
    int max = 0;
    int currMax = 0;

    for (boolean isContinue : valid) {
      currMax = isContinue ? currMax + 1 : 0;
      max = Math.max(max, currMax);
    }

    return max;
  }
}
