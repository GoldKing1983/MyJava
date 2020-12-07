package com.interview.leetcode.topic.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
===========================================================Requirement===========================================================
Given an array of integers nums[] and an integer k, return the number of unique k-diff pairs in the array.
============================================================Example1=============================================================
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
============================================================Example2=============================================================
Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
============================================================Example3=============================================================
Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
========================================================Initial Thinking=========================================================
1) It is a TwoSum problem with a twist
2) twist1 : find all combinations.
3) twist2 : skip duplicates.
========================================================Solution Approach========================================================
 1) for 0 case. Ex: [6,6,6,6] k=0 Answer=1. Because [6,6] cannot be included again.
 2) Remaining is 2 sum problem map solution.
=================================================================================================================================
 */
public class KDiffPairsInAnArray {
  public int findPairs(int[] nums, int target) {
    if (nums == null || nums.length == 0 || target < 0) return 0;

    // key is num and value is numCount. numCount is used only when target==0.
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
    if (target == 0) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // count how many elements in the array that appear more than twice.
        if (entry.getValue() >= 2) count++;
      }
      return count;
    }
    return twoSumUsingSet(map.keySet(), target);
  }

  public int twoSumUsingSet(Set<Integer> nums, Integer target) {
    int count = 0;
    for (int num : nums) {
      if (nums.contains(num + target)) count++;
    }
    return count;
  }

}
