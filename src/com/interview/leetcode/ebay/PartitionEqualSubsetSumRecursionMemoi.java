package com.interview.leetcode.ebay;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * Recursion approach will take more than 5 minutes if the input has 50+ elements
 *
 * ==========================Solution Note================================
 * Recursion Approach : Verify whether array can be split into 2 equal parts.
 * Simple approach using groupSum is...
 * If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.
 */
public class PartitionEqualSubsetSumRecursionMemoi {

  public boolean canPartition(int[] nums) {
    int sum = getSum(nums);
    if (sum % 2 == 1) return false;
    memoization = new Boolean[nums.length][sum / 2 + 1];
    return groupSum(0, nums, sum / 2);
  }

  private int getSum(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) result += nums[i];
    return result;
  }

  // For this index, for the target, cache true/false
  Boolean[][] memoization;

  private boolean groupSum(int index, int[] nums, int target) {
    if (index == nums.length || target < 0) return false;
    if (target == 0) return true;
    if (memoization[index][target] != null) return memoization[index][target];
    boolean left = groupSum(index + 1, nums, target - nums[index]);
    boolean right = groupSum(index + 1, nums, target);
    memoization[index][target] = left || right;
    return left || right;
  }
}
