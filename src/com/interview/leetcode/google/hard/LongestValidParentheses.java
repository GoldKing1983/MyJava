package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', find the length of the
longest valid (well-formed) parentheses substring.

")()())"  --> 4
"()(()()" --> 4---------Important-------
"()(())"  --> 6
 */
public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    boolean[] valid = new boolean[s.length()];

    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') stack.push(i);
      else if (!stack.isEmpty()) {
        valid[i] = true;
        valid[stack.pop()] = true;
      }
    }

    return longest(valid);
  }

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
