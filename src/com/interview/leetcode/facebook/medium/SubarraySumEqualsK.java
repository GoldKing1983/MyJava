package com.interview.leetcode.facebook.medium;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
https://www.youtube.com/watch?v=HbbYPQc-Oo4
See Also problem ContiguousArray
=========================================================Requirement=============================================================
Given an array of integers and an integer k, you need to find the total number of continuous sub-arrays
whose sum equals to k.
=================================================================================================================================
Input:nums = [1,1,1], k = 2
Output: 2
=================================================================================================================================
[0,0,0] k=0
With index0 - 0
0
0,0
0,0,0
With index1 - 0
0
0,0
With index2 - 0
0

Output : 6(1+2+3)
=================================================================================================================================
[3,2,1], k=3
Output : 2
=================================================================================================================================
[3,4,7,2,-3,1,4,2] k=7
Output : 4 (3,4--> 7 --> 7,2,-3,1 --> 1,4,2)

=================================================Solution Approach O(n)==========================================================
1) Understand SubarraySumEqualsKSlidingWindowBruteForce.
2) In above solution, we calculate sum from 0ton-1, then, we move left by 1 and do same calculation again.
3) We can optimize it. If we memoize the preSum with resultCount. 
   
=======================================================Data Flow Analysis========================================================
resultCountMap  =  1 2 3 
prefixSum       =  0 0 0   
nums            = [0,0,0], target = 0  

 */
public class SubarraySumEqualsK {
  public int subarraySumStep1(int[] nums, int target) {
    int resultCount = 0, prefixSum = 0;
    HashMap<Integer, Integer> dp = new HashMap<>();
    for (int num : nums) {
      prefixSum += num;
      /*
       *  Add the Logic here.
       */
      // Ex: [0,0,0]...target=0... at index1 dp=[0,2] This memoization will be used at index2
      dp.put(prefixSum, dp.getOrDefault(prefixSum, 0) + 1);
    }
    return resultCount;
  }

  public int subarraySum(int[] nums, int target) {
    int resultCount = 0, prefixSum = 0;
    HashMap<Integer, Integer> resultCountMap = new HashMap<>();
    for (int num : nums) {
      prefixSum += num; // step1
      // -------------------Logic Starts=================//
      if (prefixSum == target) resultCount++;

      if (resultCountMap.containsKey(prefixSum - target)) resultCount += resultCountMap.get(prefixSum - target);
      // -------------------Logic Ends=================//
      // Ex: [0,0,0]...target=0... at index1 dp=[0,2] This memoization will be used at index2 
      resultCountMap.put(prefixSum, resultCountMap.getOrDefault(prefixSum, 0) + 1); // step2
    }
    return resultCount;
  }
}
