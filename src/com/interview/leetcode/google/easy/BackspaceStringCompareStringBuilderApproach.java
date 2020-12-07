package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/backspace-string-compare/description/
==================================================================================================================================
Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
========================================================Solution Approach========================================================
=================================================================================================================================
 */
public class BackspaceStringCompareStringBuilderApproach {
  public boolean backspaceCompare(String S, String T) {
    String resultS = getResult(S);
    String resultT = getResult(T);
    return resultS.equals(resultT);
  }

  public String getResult(String S) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '#') {
        if (str.length() > 0) str.deleteCharAt(str.length() - 1);
      } else str.append(c);
    }
    return str.toString();
  }
}
