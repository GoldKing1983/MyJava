package com.interview.leetcode.topic.string.parenthesis;

/*

  Time Complexity : O(3^N)
 */
public class ValidParenthesisStringRecursion {
  public boolean checkValidString(String s) {
    return checkValidString(s, 0, 0);
  }

  private boolean checkValidString(String s, int index, int count) {
    if (count < 0) return false;

    if (index == s.length()) return count == 0;

    if (s.charAt(index) == '(') {
      return checkValidString(s, index + 1, count + 1);

    } else if (s.charAt(index) == ')') {
      return checkValidString(s, index + 1, count - 1);
    } else {
      boolean considerOpen = checkValidString(s, index + 1, count + 1);
      boolean considerClose = checkValidString(s, index + 1, count - 1);
      boolean neightherOperNorClose = checkValidString(s, index + 1, count);

      if (considerOpen || considerClose || neightherOperNorClose) return true;
    }
    return false;
  }
}
