package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/contains-duplicate-ii/

Problem Statement: Given two distinct indices i and j in the array such that nums[i] = nums[j] and the
absolute difference between indices i and indices j is "at most" K i.e less than or equal to K.

Input: nums = [1,2,3,1], k = 3
Output: true

Here element at indices 0 is nums[0]=1 and element at indices 3 is nums[3]=1 which are equal.
Since nums[0] and nums[3] are distinct indices with nums[0]==nums[3]. Also difference between indices 3 and 0 is 3

--> nums[0] == nums[3]
--> (3-0) <= 3 (here k=3 and condition is that difference between indices must not be greater than 3)
--> Hence output is true
==================================================Solution Approach========================================================
1) Save the number with index in map. Lets say it is left(index).
2) If the same number comes again lets say right(index), before insertion, take the left(index).
		2a) If right-left<=k return true.
		2b) Else update value to right index.
3) If different number add the number to map or move right.
==========Tricky part===========
Since requirement is i<=k we are overriding or updating right index.
If requirement is 	 i>=k we need to keep the old index or left index.
===========================================================================================================================
 */
public class ContainsDuplicateIIBest {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer right = 0; right < nums.length; right++) {
      Integer currentNumber = nums[right];
      boolean isCurrNumberExists = map.containsKey(currentNumber);
      if (isCurrNumberExists) {
        Integer left = map.get(currentNumber);
        if (right - left <= k) return true;
      }
      map.put(nums[right], right);
    }
    return false;
  }
}
