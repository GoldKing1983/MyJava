package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Input:[5,8,7,1,9]
Output: [5,8,9] or [5,7,9] size is 3.
======================================Solution Approach- Time Complexity n(log n)==============================================
1) Create search-space in "dp array" from input.
2) If the number is not available in dp. Insert it at appropriate index.
3) If the number is already available in dp. It will be skipped.
4) Other than duplicate all the element will be placed in dp in right index in ascending order.
5) Ex: [3,2,1]... Initially 3 placed at index0.
					   Then 2 placed at index0.
					   Then 1 placed at index0.

6) Ex: [1,2,3]... Initially 1 placed at index0.
					   Then 2 placed at index1.
					   Then 3 placed at index2.

==================================================Data Flow Analysis=========================================================
Ex: [2,3,500,600,4,5,6] Output: 5
[]
[2]
[2, 3]
[2, 3, 500]
[2, 3, 500, 600]
[2, 3, 4, 600]
[2, 3, 4, 5]
[2, 3, 4, 5, 6]

 */
public class LongestIncreasingSubSequenceBinarySearch {

  public int lengthOfLIS(int[] nums) {
    List<Integer> dp = new ArrayList<>();
    for (int num : nums) {
      /*
       * returns index of the search key, if it is contained in the array within the specified range;
       * otherwise, (-(insertion point) - 1).
       * Ex: If "dp" is empty. search for 1. will return -1. Stating it needs to be inserted at 0.
       * The insertion point is defined as the point at which the key would be inserted into the array:
       */
      int indexToInsert = Collections.binarySearch(dp, num);
      if (indexToInsert >= 0) continue; // Element already exists.
      indexToInsert = -(indexToInsert + 1);
      if (indexToInsert == dp.size()) dp.add(num); // dp is empty during first time. So just add.
      else dp.set(indexToInsert, num);
    }
    return dp.size();
  }
}
