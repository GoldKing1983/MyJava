package com.interview.leetcode.ebay;

import java.util.Arrays;
import com.leetcode.dynamicprogramming.GroupSumDP;

/*
https://leetcode.com/problems/partition-equal-subset-sum/description/

Solution Note using GroupSum Approach : Verify whether array can be split into 2 equal parts.
If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.

*/
public class PartitionEqualSubsetSumDynamic {

  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) return false;

    GroupSumDP g = new GroupSumDP();
    return g.groupSum(nums, sum / 2);
  }
}
