package com.interview.leetcode.amazon.medium;

import java.util.Stack;
/*
https://leetcode.com/problems/score-of-parentheses/

==================Condition for Score:==================
() has score 1
AB --> ()() -->  has score A + B, where A and B are "balanced parentheses strings"
(A)--> (()) --> has score 2 * A, where A is a "balanced parentheses string"
========================================
input: "((()))" Output: 4
((1)) --> (2) --> 4
========================================
Input: "(()(()))" Output: 6
(1(())) --> (1(1)) --> (1 2) --> (3) --> 6
========================================

 */
public class ScoreOfParentheses {
  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') {
        stack.push(0);
      } else if (c == ')') {
        int pop = stack.pop() * 2;
        pop = (pop == 0) ? 1 : pop;
        if (!stack.isEmpty()) {
          int top = stack.pop();
          stack.push(top + pop);
        } else {
          result += pop;
        }
      }
    }
    return result;
  }
}
