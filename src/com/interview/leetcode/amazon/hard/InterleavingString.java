package com.interview.leetcode.amazon.hard;
/*
https://leetcode.com/problems/interleaving-string/
======================================================================Solution Approach==========================================
1) If the letter at s1Index matches with the letter at s3Index, we can recursively match for the remaining lengths of ‘s1’ and ‘s3’.
2) If the letter at s2Index matches with the letter at s3Index, we can recursively match for the remaining lengths of ‘s2’ and ‘s3’.
==================================================================================================================================
 */
public class InterleavingString {

  public boolean isInterleave(String m, String n, String p) {
    return findSIRecursive(m, n, p, 0, 0, 0);
  }

  private boolean findSIRecursive(
      String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {

    // if we have reached the end of the all the strings
    if (s1Index == s1.length() && s2Index == s2.length() && s3Index == s3.length()) return true;

    // if we have reached the end of 'p' but 'm' or 'n' still have some characters left
    if (s3Index == s3.length()) return false;

    boolean b1 = false, b2 = false;
    if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s3Index))
      b1 = findSIRecursive(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1);

    if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s3Index))
      b2 = findSIRecursive(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1);

    return b1 || b2;
  }
}
