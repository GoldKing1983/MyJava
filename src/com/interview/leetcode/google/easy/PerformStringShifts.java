package com.interview.leetcode.google.easy;

/*

You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.



Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"

======================================================================Solution Approach=========================================
1) Sum all the directions. left is - and right +.
2) If the sum is negative, then we know finally it has to do left shift
3) If the sum is positive, then we know finally it has to do right shift
 */
public class PerformStringShifts {
  public String stringShift(String s, int[][] shift) {
    int rot = 0;
    // If left subtract. If right add.
    for (int[] sh : shift) rot = sh[0] == 0 ? rot - sh[1] : rot + sh[1];
    if (rot < 0) { // left rotation.
      rot = -rot;
      rot = rot % s.length();
      // Ex: abc.. left by 1... bca
      return s.substring(rot) + s.substring(0, rot);
    }

    rot = rot % s.length();
    // Ex: abc.. left by 1... cab
    return s.substring(s.length() - rot) + s.substring(0, s.length() - rot);
  }
}
