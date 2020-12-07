package com.interview.leetcode.amazon.hard;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/interleaving-string/

======Complexity Analysis=============
Time complexity : O(m+n ^ 2). m is the length of s1. and n is the length of s2.
Space complexity : O(m+n). The size of stack for recursive calls can go upto m+n.
 */
public class InterleavingStringWithMemo {

  public boolean isInterleave(String m, String n, String p) {
    return findSIRecursive(m, n, p, 0, 0, 0, new HashSet<Integer>());
  }

  private boolean findSIRecursive(
      String s1,
      String s2,
      String s3,
      int s1Index,
      int s2Index,
      int s3Index,
      Set<Integer> visited) {
    int hash = s1Index * 500 + s2Index;
    if (visited.contains(hash)) return false;

    // if we have reached the end of the all the strings
    if (s1Index == s1.length() && s2Index == s2.length() && s3Index == s3.length()) return true;

    // if we have reached the end of 'p' but 'm' or 'n' still have some characters left
    if (s3Index == s3.length()) return false;

    boolean left = false, right = false;
    if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s3Index))
      left = findSIRecursive(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, visited);

    if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s3Index))
      right = findSIRecursive(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, visited);

    visited.add(hash);
    return left || right;
  }
}
