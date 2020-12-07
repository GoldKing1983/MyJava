package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/flip-game/
 *
1) Turn 2 consecutive "++" to "--"

Input: s = "++"
Output:
[
  "--",
]

Input: s = "++++"
Output:
[
  "--++",
  "+--+",
  "++--"
]

 */
public class FlipGame {
  public List<String> generatePossibleNextMoves(String s) {
    char[] ss = s.toCharArray();
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < ss.length - 1; i++) {
      if (ss[i] == '+' && ss[i + 1] == '+') {
        ss[i] = '-';
        ss[i + 1] = '-';
        ans.add(new String(ss));
        ss[i] = '+';
        ss[i + 1] = '+';
      }
    }
    return ans;
  }
}
