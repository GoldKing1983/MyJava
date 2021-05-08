package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

Added if condition for below case at line33... Everything is same.
[2,2,2,2,2,2,2,2,2,2,2,2,2,3,3]
8


 */
public class PartitionToKEqualSumSubsetsBackTrack2 {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (k <= 0 || sum % k != 0) return false;
    return canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);

  }

  private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int currentSum,
      int targetSum) {
    if (k == 1) return true;

    if (currentSum > targetSum) return false;

    if (currentSum == targetSum) return canPartition(nums, visited, 0, k - 1, 0, targetSum);

    // loop executed when currentSum < targetSum
    for (int i = start; i < nums.length; i++) {

      if (i > start && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

      if (visited[i]) continue;
      visited[i] = true;
      if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], targetSum)) return true;
      visited[i] = false;
    }

    return false;
  }
}
