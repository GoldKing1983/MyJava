package com.interview.leetcode.topic.string.parenthesis;

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

                      "empty"
                  /       |
                 (
                / \
               (   )
              / \
             (   )  
            / \
               )
               
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

public class GenerateParenthesesBackTrack {

  public List<String> generateParenthesis(int n) {
    return generateParenthesis(n, new StringBuilder(), new ArrayList<>(), 0, 0);
  }

  // backtracking
  private List<String> generateParenthesis(int n, StringBuilder currResult, List<String> result,
      int openCount, int closeCount) {

    if (openCount == n && closeCount == n) {
      result.add(currResult.toString());
      return result;
    }

    if (openCount > n || closeCount > openCount) return result;

    //include open
    generateParenthesis(n, currResult.append("("), result, openCount + 1, closeCount);
    currResult.deleteCharAt(currResult.length() - 1);

    //include close
    generateParenthesis(n, currResult.append(")"), result, openCount, closeCount + 1);
    currResult.deleteCharAt(currResult.length() - 1);

    return result;
  }
}
