package com.interview.leetcode.topic.string.parenthesis;

public class ValidParenthesisStringBest {
  public boolean checkValidString(String s) {
    int leftP = 0, star = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') leftP++;
      // A ')' need one '(' or 1 '*'.
      else if (ch == ')') {
        if (leftP > 0) leftP--;
        else if (star > 0) star--;
        else return false;
      }
      // consume the left "(" but also be ready for next ")". A star can cover for 1 '(' and at max
      // two '(' if there is one left '(' before.
      else {
        if (leftP > 0) {
          leftP--;
          star++; // Ex1: (*))... Ex2: (*)
        }
        star++;
      }
    }
    return leftP == 0;
  }
}
