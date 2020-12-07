package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

Given an array arr, replace every element in that array with the greatest element among the elements to its right,
and replace the last element with -1.

After doing so, return the array.

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
========================================Just Code for the requirement. No magic================================
1) Scan from last.
2) For "nthElement" nothing is greater after it, because it is the lastElement. So set -1 at nthResultLocation.
Mark nthElement as previousGreater. 
3) Move on the next index. If currentIndex value 
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

  public int[] replaceElements(int[] arr) {
    int n = arr.length - 1;
    int prevGreater = arr[n];
    arr[n] = -1;
    n--;
    while (n >= 0) {
      int current = arr[n];
      arr[n] = prevGreater;
      prevGreater = Math.max(current, prevGreater);
      n--;
    }
    return arr;
  }
}
