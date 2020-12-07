package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/shortest-way-to-form-string/

From any string, we can form a subsequence of that string by deleting some number of
characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source
such that their concatenation equals target. If the task is impossible, return -1.

===============================================================================================
Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
===============================================================================================
Input: source = "abc", target = "abab"
Output: 2
Explanation: The target "abab" can be formed by "ab" and "ab", which are subsequences of source "abc".
===============================================================================================
Input: source = "abc", target = "abbc"
Output: 2
Explanation: The target "abbc" can be formed by "ab" and "bc", which are subsequences of source "abc".
===============================================================================================
Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
===============================================================================================
Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".

========================================Theory================================================================================
1) Generally in Sliding Window, left moves slowly and right goes faster.
   		When right goes to the endOfArray. Code Terminates.
2) Here When right goes to the endOfArray, left continues. Code terminates
		when left  goes to the endOfArray.
=============================Solution Approach==================================================================
0) Simple Sliding Window.

1) left point target and right point source.

2) Left Move slowly. Right goes from 0 to end, again set to 0 for every iteration.

Ex: source = "xyz", target = "xzyxz"
Iteration1: Number of Matching = 2. i.e. "xz" at target.
Iteration2: Number of Matching = 1. i.e. "y" at target.
Iteration3: Number of Matching = 2. i.e. "xz" at target.

Starting 'target left' and 'source right' with position: 0
'target left':0, 'source right':0
'target left':1, 'source right':1
'target left':1, 'source right':2
Count Matched in Target2

'target left' new starting position: 2
Resetting 'source right' position to: 0
'target left':2, 'source right':0
'target left':2, 'source right':1
'target left':3, 'source right':2
Count Matched in Target1

'target left' new starting position: 3
Resetting 'source right' position to: 0
'target left':3, 'source right':0
'target left':4, 'source right':1
'target left':4, 'source right':2
Count Matched in Target2
'target left' new starting position: 5
All characters in target has been matched by source. Returning 5.

 */
public class ShortestWayToFormString {
  public int shortestWay(String sourceString, String targetString) {
    char[] source = sourceString.toCharArray();
    char[] target = targetString.toCharArray();
    int count = 0;
    int left = 0, right = 0;
    while (true) {
      int com = common(source, target, left, right);
      if (com == 0) return -1; // If no match in current iteration, return -1.
      left += com; // Updating left to new position.
      count++;
      right = 0; // Resetting right.
      if (left == target.length) return count;
    }
  }

  // left operates on target and right operates on source
  private int common(char[] source, char[] target, int left, int right) {
    int count = 0;
    while (left < target.length && right < source.length) {
      if (source[right] == target[left]) {
        left++;
        right++;
        count++;
      } else {
        right++;
      }
    }
    return count;
  }
}
