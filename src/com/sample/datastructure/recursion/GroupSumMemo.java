package com.sample.datastructure.recursion;

import java.util.Arrays;

public class GroupSumMemo {
  Boolean[][] memo;

  public boolean groupSum(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    memo = new Boolean[nums.length][sum + 1];
    return groupSum(nums, target, 0);
  }

  private boolean groupSum(int[] nums, int target, int index) {
    if (target == 0) return true;
    if (index == nums.length || target < 0) return false;
    if (memo[index][target] != null) return memo[index][target];
    boolean left = groupSum(nums, target - nums[index], index + 1);
    boolean right = groupSum(nums, target, index + 1);
    memo[index][target] = left || right;
    return left || right;
  }
}
