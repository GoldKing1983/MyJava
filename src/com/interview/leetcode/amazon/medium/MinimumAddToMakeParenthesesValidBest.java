package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

Given a inputString of '(' and ')' parentheses, we add the minimum number of '(' and ')' parentheses in
"any positions", so that the resulting parentheses string is valid.

return the minimum number of parentheses we must add to make the resulting string valid.

Input: "())"
Output: 1 --> Add 1 '(' at beginning

Input: "((("
Output: 3 --> Add 3 ')' at end

Input: "()"
Output: 0

Input: "()))(("
Output: 4 --> Add 2 '(' at beginning and 2 ')' at end.
========================================High Level Thinking======================================================================
1) Logically thinking we need to add '(' at beginning and ')' at end to make inputString valid.
2) But question is not about generating or updating inputString to validInputString.
========================================Solution Approach========================================================================
1) Balance the '(' and ')'.
2) What is a balance here? If currentChar is ')'  and if '(' is present b4 current, then it is balanced.
3) If currentChar is '(' simply increment openCount.
4) If currentChar is ')' if openCount>0. Then decrement openCount, to update balanced.
						 Else increment resultCount.
5) Result is left-over unBalanced "openCount+resultCount"
 */
public class MinimumAddToMakeParenthesesValidBest {
  public int minAddToMakeValid(String input) {
    int openCount = 0;
    int resultCount = 0;

    for (char currChar : input.toCharArray()) {
      if (currChar == '(') {
        openCount++;
      } else { // Case ')'
        if (openCount > 0) { // verify balance
          openCount--; // Yes balance, so decrement openCount
        } else {
          resultCount++;
        }
      }
    }

    return openCount + resultCount;
  }
}
