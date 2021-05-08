package com.walmart.string;

/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray

Similar to "GroupSum6" and not "GroupSum".
 		i.e GroupSum ==> Go in 2path(left&right) vs GroupSum ==> Go in 1path If 6 Else Go in 2path(left&right)
=============================================Solution Approach=====================================================================
1) If the strings have a matching character, we can recursively match for the remaining lengths and keep a
track of the current matching length.
2) If the strings don’t match, we start two new recursive calls by skipping one character separately
from each string and reset the matching length.
3) Return "max(matchingLCS, leftLCS, rightLCS)"
===================================================================================================================================
Ex1:
[12301]
[12341]

Output:3
=============================
Ex1:
[12301]
[11231]

Output:3
 */
public class LongestCommonSubStringRecursion {
  public int findLCSLength(String s1, String s2) {
    return findLCSLengthRecursive(s1, s2, 0, 0, 0);
  }

  private int findLCSLengthRecursive(
      String s1, String s2, int s1Index, int s2Index, int matchingLCS) {
    if (s1Index == s1.length() || s2Index == s2.length()) return matchingLCS;

    if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
      // Cannot return here. Then for Ex1, output will be1. i.e. Only last match will be returned
      matchingLCS = findLCSLengthRecursive(s1, s2, s1Index + 1, s2Index + 1, matchingLCS + 1);
    }

    // Every time I need to reset the lcs to 0.
    int leftLCS = findLCSLengthRecursive(s1, s2, s1Index, s2Index + 1, 0);
    int rightLCS = findLCSLengthRecursive(s1, s2, s1Index + 1, s2Index, 0);

    return Math.max(matchingLCS, Math.max(leftLCS, rightLCS));
  }
}
