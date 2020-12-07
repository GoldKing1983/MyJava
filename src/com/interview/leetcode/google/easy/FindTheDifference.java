package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {
  public char findTheDifference(String s, String t) {
    int n = s.length();
    char result = 0;
    for (int i = 0; i < n; i++) {
      result ^= t.charAt(i) ^ s.charAt(i);
    }
    result ^= t.charAt(n);
    return result;
  }

  public char findTheDifference1(String s, String t) {
    int n = s.length();
    int result = 0;
    for (int i = 0; i < n; i++) {
      result ^= (s.charAt(i) ^ t.charAt(i));
    }
    result ^= t.charAt(n);
    return (char) result;
  }
}
