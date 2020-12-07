package com.interview.leetcode.topic.array;

/*
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j].

Return the number of good pairs.

==============================================================Example1===========================================================
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
==============================================================Example2===========================================================
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

=========================================================Data Flow Analysis======================================================
Input: nums = [1,1,1,1]
Output: 6

    0   1   3   6   10  15  21  28
    
    preSum      dp[i]       = preSum
    0       +       0       = 0
    0       +       1       = 1
    1       +       2       = 3
    3       +       3       = 6   =====> Return result at this level.
    6       +       4       = 10
    10      +       5       = 15 
    15      +       6       = 21
    21      +       7       = 28

 */
public class NumberOfGoodPairs {
  public int numIdenticalPairs(int[] nums) {
    int preSum = 0;
    int[] dp = new int[101];
    for (int num : nums) {
      // Add previous dp[num] to preSum
      preSum = preSum + dp[num];
      // Update dp[num] count of occurrence
      dp[num]++;
    }
    return preSum;
  }
}
