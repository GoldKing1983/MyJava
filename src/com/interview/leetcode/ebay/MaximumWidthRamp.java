package com.interview.leetcode.ebay;

import java.util.TreeMap;

/*
============================================================Requirement==========================================================
https://leetcode.com/problems/maximum-width-ramp/

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

Input: [6,0,8,2,1,5]
Output: 4
Explanation:
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation:
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
=====================================================Solution Approach - O(NlogN)================================================
1) If there is only 1 number or zero present in input then rampSize is 0.
2) If nothing       exists below the currentNumber. Then add currentNumber to map with its index.
3) If somethingThen exists below the currentNumber. Then get that index and calculate currRampWidth and maxRampWidth.
===============================================================Data Flow Analysis================================================
Input : [4,3,5,2,1,6]
map = {4=0} 					maxRampWidth = 0
map = {3=1, 4=0} 				maxRampWidth = 0
map = {3=1, 4=0} 				maxRampWidth = 2 == Note 5 is not added in map. So for 6. 4 will be floor.
map = {2=3, 3=1, 4=0} 			maxRampWidth = 2
map = {1=4, 2=3, 3=1, 4=0} 		maxRampWidth = 2
map = {1=4, 2=3, 3=1, 4=0} 		maxRampWidth = 5

 */
public class MaximumWidthRamp {
  public int maxWidthRamp(int[] nums) {
    int maxRampWidth = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int currentRampIndex = 0; currentRampIndex < nums.length; currentRampIndex++) {
      boolean nothingExistsBelowCurrentNumber = map.floorKey(nums[currentRampIndex]) == null;
      if (nothingExistsBelowCurrentNumber) map.put(nums[currentRampIndex], currentRampIndex);
      else {
        int previousRampIndex = map.floorEntry(nums[currentRampIndex]).getValue();
        int currRampWidth = currentRampIndex - previousRampIndex;
        if (currRampWidth > maxRampWidth) maxRampWidth = currRampWidth;
      }
    }
    return maxRampWidth;
  }
}
