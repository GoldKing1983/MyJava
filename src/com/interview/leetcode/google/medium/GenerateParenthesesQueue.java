package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/generate-parentheses/description/
https://www.educative.io/courses/grokking-the-coding-interview/NEXBg8YA5A2

*/

public class GenerateParenthesesQueue {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    Queue<Object[]> queue = new LinkedList<>();
    queue.add(new Object[] {"", 0, 0});
    while (!queue.isEmpty()) {
      Object[] ps = queue.poll();
      String currentCombo = (String) ps[0];
      int openCount = (int) ps[1];
      int closeCount = (int) ps[2];
      if (openCount == n && closeCount == n) {
        result.add(currentCombo);
        continue;
      }
      if (openCount < n) queue.add(new Object[] {currentCombo + '(', openCount + 1, closeCount});
      if (openCount > closeCount)
        queue.add(new Object[] {currentCombo + ')', openCount, closeCount + 1});
    }
    return result;
  }
}
