package com.leetcode.interview;

/*
https://leetcode.com/problems/jump-game/
===============================================Requirement======================================================
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
================================================Example1======================================================
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
================================================Example2======================================================
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
==========================================================


 */
public class JumpGame {

  public boolean canJump(int[] nums) {
    int maxJump = 0;
    int n = nums.length - 1; // Ex: [0]. Ans: true. Loop will not execute.
    for (int i = 0; i < n; i++) {
      int currentMaxJump = i + nums[i];
      maxJump = Math.max(maxJump, currentMaxJump);
      if (maxJump >= n) return true; // Ex: [5,4,3,2,1,0] Ans: True. Return at first iteration
      if (maxJump == i) return false; // Ex: [0,2,3] Ans: false
    }
    return true;
  }
}
