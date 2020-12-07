package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/description/
=============================================Requirement============================================================
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
=============================================Solution Approach============================================================
1) Permute all combination of "(" and ")" recursively.

2) The idea here is to only add "(" and then ")".

Ex1 for n=3: ()) is invalid. So don't take that path.
Above condition is achieved if "closeCount>openCount" return.

Ex2 for n=3: (((( is invalid. So don't take that path.
Above condition is achieved if "openCount>n" return.

3) BackTrack happens at 2 places.
==================================================Data Flow Approach======================================================
n = 3 OutputSize:5
(
((
(((
((()
((())
((())) ---->1
(()
(()(
(()()
(()()) ---->2
(())
(())(
(())() ---->3
()
()(
()((
()(()
()(()) ---->4
()()
()()(
()()() ---->5

*/

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    permute(0, 0, result, new StringBuilder(), n);
    return result;
  }

  private void permute(
      int openCount, int closeCount, List<String> result, StringBuilder currentCombo, int n) {
    if (openCount > n || closeCount > openCount) return;
    if (openCount == n && closeCount == n) {
      result.add(currentCombo.toString());
      return;
    }
    permute(openCount + 1, closeCount, result, currentCombo.append('('), n);
    currentCombo.deleteCharAt(currentCombo.length() - 1); // backtrack

    permute(openCount, closeCount + 1, result, currentCombo.append(')'), n);
    currentCombo.deleteCharAt(currentCombo.length() - 1); // backtrack
  }
}
