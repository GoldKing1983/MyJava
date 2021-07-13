package com.interview.leetcode.google.hard;

/*
https://leetcode.com/problems/longest-valid-parentheses/

Given a string containing just the characters '(' and ')', find the length of the
longest valid (well-formed) parentheses substring.

")()())" --> 4----------------max arrived from leftToRight
"()(()()" --> 4----------------max arrived from rightToLeft
"()(())" --> 6----------------max arrived from both the side
=========================================================Initial Thought=========================================================
1) This solution is inspired by "MaximumSubArraySum"
2) Let's recall the O(n) solution for that problem: we give up when the "currentSum < 0",
set the "currentSum = 0" and restart counting from the next number; and we records the maximum all the time.
3) In this problem, we use sum to indicate whether the expression is balanced.
========================================================Solution Approach========================================================
			=========For LeftToRight========
1) +1 to represent '(' and -1 for ')'; 
2) if sum == 0, then the substring is balanced;
3) sum < 0 means the expression is unbalanced, where we give up the "currMax" and start again.
Ex: ")))()"
4) However, when we scan from "leftToRight", we only find the expression balance for "("
Ex: (() --> for this input 	"leftToRight"  max is 0.
			=========For RightToLeft========
1) +1 to represent ')' and -1 for '('; ========================****** Very Very Important...Note we are reversing...  
2) if sum == 0, then the substring is balanced;
3) sum < 0 means the expression is unbalanced, where we give up the "currMax" and start again.
Ex: (() --> for this input 	"RightToLeft"  max is 2.
 
================================================================================================================================
 */
public class LongestValidParenthesesBest {

  public int longestValidParentheses(String s) {
    if (s.length() == 0) return 0;

    int sum = 0, max = 0, currMax = 0, n = s.length();
    // Scan the string from left side, plus 1 for '(' and minus 1 for ')'.
    for (Character c : s.toCharArray()) {
      if (c == '(') sum++;
      else sum--;

      if (sum < 0) {
        sum = 0;
        currMax = 0;
      } else {
        currMax++;
        if (sum == 0) max = Math.max(max, currMax);// Only when balanced calculate max.
      }
    }

    // Scan again from right side, plus 1 for ')' and minus 1 for '('.
    char[] str = s.toCharArray();
    sum = 0;
    currMax = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (str[i] == ')') sum++;
      else sum--;
      if (sum < 0) {
        sum = 0;
        currMax = 0;
      } else {
        currMax++;
        if (sum == 0) max = Math.max(max, currMax);// Only when balanced calculate max.
      }
    }
    return max;
  }
}
