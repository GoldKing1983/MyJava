package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array
that occurs more than 25% of the time.


Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Explanation: Total Element 9. 25% = 3...So element which occurs more than 3 times is answer.
=======================================================Solution Approach=========================================================
1) For each of currentElement, verify element after 25%. If both are same. return it.
 */
public class ElementAppearingMoreThan25PercentageInSortedArray {
  public int findSpecialInteger(int[] arr) {
    int n = (int) (arr.length * 0.75); // Travel only 75%
    int indexOf25Percentage = (int) (arr.length * 0.25);
    for (int i = 0; i < n; i++) {
      if (arr[i] == arr[i + indexOf25Percentage]) {
        return arr[i];
      }
    }
    return arr[0];
  }
}
