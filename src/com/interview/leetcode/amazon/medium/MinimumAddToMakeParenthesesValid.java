package com.interview.leetcode.amazon.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
1) Classic way of solving with stack
2) If currentChar is '(', simply push it to stack.
3) If currentChar is ')'. verify it is balanced, if yes remove the top. Else push ')' it to stack.

 */
public class MinimumAddToMakeParenthesesValid {
  public int minAddToMakeValid(String S) {
    Deque<Character> stack = new ArrayDeque<>();
    for (Character c : S.toCharArray()) {
      if (c == ')') {
        if (!stack.isEmpty()) {
          if (stack.peek() == '(') {
            stack.pop();
            continue;
          }
        }
        stack.push(')');
      } else {
        stack.push('(');
      }
    }
    return stack.size();
  }
}
