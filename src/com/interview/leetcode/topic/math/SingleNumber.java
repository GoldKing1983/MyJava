package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/single-number/
===========================================================Requirement===========================================================
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
============================================================Example1=============================================================  
Input: nums = [2,2,1]
Output: 1
============================================================Example2=============================================================
Input: nums = [4,1,2,1,2]
Output: 4
=======================================================Data Flow Analysis========================================================
Input:  nums = [2,2,1]
result  = 0^2^2^1
        = 0^(2^2)^1
        = 0^0^1
Output: =1
=======================================================Data Flow Analysis========================================================
Input:  nums = [4,1,2,1,2]
result  = 0^4^(1^1)^(2^2)
        = 0^4^0^0
        = 0^4^0
        = (0^0)^4
Output: = 4
=================================================================================================================================        
 */
public class SingleNumber {

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }
}
