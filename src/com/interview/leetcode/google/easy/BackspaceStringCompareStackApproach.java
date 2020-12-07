package com.interview.leetcode.google.easy;

import java.util.ArrayDeque;
import java.util.Deque;

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
1) Simple stack approach.
2) If "#" found and if stack is not empty. pop
3) Else push it to stack.
=================================================================================================================================
 */
public class BackspaceStringCompareStackApproach {
  public boolean backspaceCompare(String string1, String string2) {

    String s1 = deleteCharBeforeHash(string1);
    String s2 = deleteCharBeforeHash(string2);
    return s1.equals(s2);
  }

  private String deleteCharBeforeHash(String str) {
    Deque<Character> stack = new ArrayDeque<>();
    for (Character c : str.toCharArray()) {
      if (c == '#') {
        if (!stack.isEmpty()) stack.pop();
      } else {
        stack.push(c);
      }
    }
    char[] result = new char[stack.size()];
    int i = 0;
    while (!stack.isEmpty()) result[i] = stack.pop();
    return new String(result);
  }
}
