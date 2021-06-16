package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/longest-mountain-in-array/

1) Given an array A of integers, return the length of the longest mountain.
2) Data is considered Mountain if it goes up and comes down.
3) Ex: [1,2,2,1] is not considered mountain or result is 0.

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

==========================================================Solution Approach===============================================
1) Record increasing order from leftToRight.
2) Record increasing order from rightToLeft.
3) If either side 0. Ignore it.
4) Else Result is "sum of both + 1",  cache the max.
==========================================================Data Flow Analysis==============================================
Input: [2,1,4,7,3,2,5]
Output: 5

input       = [2, 1, 4, 7, 3, 2, 5]
leftToRight = [0, 0, 1, 2, 0, 0, 1]
rightToLeft = [1, 0, 0, 2, 1, 0, 0]

==========================================================Data Flow Analysis==============================================
Input: [1,2,2,1]
Output: 0
 
input       = [1, 2, 2, 1]
leftToRight = [0, 1, 0, 0]
rightToLeft = [0, 0, 1, 0]
==========================================================Data Flow Analysis==============================================
Input: [1,2,1]
Output: 3

input       = [1, 2, 1]
leftToRight = [0, 1, 0]
rightToLeft = [0, 1, 1]
==========================================================Data Flow Analysis==============================================
Input: [1,2,3]
Output: 0

input		= [1, 2, 3]
leftToRight = [0, 1, 2]
rightToLeft = [0, 0, 0]
==========================================================================================================================
 */
public class LongestMountainInArray2Pass {
  public int longestMountain(int[] a) {
    int[] leftToRight = new int[a.length];
    for (int i = 1; i < a.length; i++) {
      if (a[i] > a[i - 1]) {
        leftToRight[i] = leftToRight[i - 1] + 1;
      }
    }
    int[] rightToLeft = new int[a.length];
    for (int i = a.length - 2; i >= 0; i--) {
      if (a[i] > a[i + 1]) {
        rightToLeft[i] = rightToLeft[i + 1] + 1;
      }
    }
    int max = 0;
    for (int i = 0; i < a.length; i++) {
      if (leftToRight[i] == 0 || rightToLeft[i] == 0) continue;
      max = Math.max(leftToRight[i] + rightToLeft[i] + 1, max);
    }
    return max;
  }
}
