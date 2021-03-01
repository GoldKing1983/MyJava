package com.interview.leetcode.topic.recursion;

/*
 *
 * https://leetcode.com/problems/house-robber-ii/

Requirement:
	1) Out of "N" houses, thief cannot stole from two adjacent houses.
	2) The first house is the neighbor of the last one.
=============================================Solution Approach=============================================
	1) Rob from 0 to n-1 house.
	2) Rob from 1 to n house.
	3) Whichever max is the answer.
	4) Use the previous "HouseRobber Solution" to rob adjacent house.
*/

public class HouseRobberII {

  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    int firstToNMinus1 = rob(nums, 0, nums.length - 1);
    int secondToN = rob(nums, 1, nums.length);
    return Math.max(firstToNMinus1, secondToN);
  }

  // Same as "HouseRobber" code with index low and high
  public int rob(int[] nums, int low, int high) {
    int fN = 0;
    int fNMinus1 = 0;
    int fNMinus2 = 0;
    for (int i = low; i < high; i++) {
      fN = Math.max(fNMinus2 + nums[i], fNMinus1);
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }
}
