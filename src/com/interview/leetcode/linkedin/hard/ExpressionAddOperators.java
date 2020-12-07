package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/expression-add-operators/solution/
===========================================================Requirement===========================================================
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators 
+, -, or * between the digits so they evaluate to the target value.

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Input: num = "222", target = 24
Output: ["2+22", "22+2"]

========================================================Solution Approach========================================================
A little trick is that we should save the value that is to be multiplied in the next recursion.

Note: The result should include all input characters.


===========Note:   Understand ExpressionAddOperatorsPlusMinusAlone.java before looking into this======

1
1+2
1+2+3
1+2-3
1+2*3
1-2
1-2+3
1-2-3
1-2*3
1*2
1*2+3
1*2-3
1*2*3
1+23
1-23
1*23
12
12+3
12-3
12*3
123


 */
public class ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(res, sb, num.toCharArray(), 0, target, 0, 0);
    return res;

  }

  public void dfs(List<String> res, StringBuilder sb, char[] num, int index, int target, long prev,
      long multi) {
    if (index == num.length) {
      if (target == prev) res.add(sb.toString());
      return;
    }
    long curr = 0;
    for (int i = index; i < num.length; i++) {
      if (num[index] == '0' && i != index) break;
      curr = 10 * curr + num[i] - '0';
      int len = sb.length();
      if (index == 0) {
        dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
        sb.setLength(len);
      } else {
        dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
        sb.setLength(len); // backtrack

        dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
        sb.setLength(len); // backtrack

        dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr,
            multi * curr);
        sb.setLength(len); // backtrack
      }
    }
  }
}
