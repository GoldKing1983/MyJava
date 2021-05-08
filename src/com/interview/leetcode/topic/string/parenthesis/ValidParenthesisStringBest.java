package com.interview.leetcode.topic.string.parenthesis;

public class ValidParenthesisStringBest {
  public boolean checkValidString(String s) {
    int openCount = 0, star = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') openCount++;
      // A ')' need one '(' or 1 '*'.
      else if (ch == ')') {
        if (openCount > 0) openCount--;
        else if (star > 0) star--;
        else return false;
      }
      // consume the left "(" but also be ready for next ")". 
      else {

        if (openCount == 0) star++; // for case: *)  

        if (openCount > 0) {
          openCount--; // case: (*
          star = star + 2; // case: (*))  also (*)   
        }

      }
    }
    return openCount == 0;
  }
}
