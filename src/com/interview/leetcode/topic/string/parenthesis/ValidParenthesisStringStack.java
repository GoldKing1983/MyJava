package com.interview.leetcode.topic.string.parenthesis;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/valid-parenthesis-string/
https://www.youtube.com/watch?v=KuE_Cn3xhxI

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid.
We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

Input: "()"
Output: True

Input: "(*)"
Output: True

Input: "(*))"
Output: True

Input: "(*"
Output: True

Input: "*)"
Output: True

Input: "*("
Output: False

=================================Solution Approach - Must see video=================================
Step1) Balance CloseParenthesis

Step2) Balance LeftOver OpenParenthesis
 */
public class ValidParenthesisStringStack {
  public boolean checkValidString(String s) {
    Deque<Integer> openStack = new ArrayDeque<>();
    Deque<Integer> starStack = new ArrayDeque<>();

    // Step1) Balance CloseParenthesis
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') openStack.push(i);
      else if (s.charAt(i) == '*') starStack.push(i);
      else { // Balance CloseParenthesis
        if (!openStack.isEmpty()) openStack.pop();
        else if (!starStack.isEmpty()) starStack.pop();
        else return false;
      }
    }

    // Ex1: (* -- True
    // Ex2: *( -- False
    while (!openStack.isEmpty() && !starStack.isEmpty())
      if (starStack.pop() < openStack.pop()) return false;

    return openStack.isEmpty();
  }
}
