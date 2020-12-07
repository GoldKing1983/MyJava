package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * 1) We use an array isVisited[] to record which element in nums[] is used for grouping the sum.
 * 2) Each time when we get a currentSum = target, we start again from position 0 in nums[] for unvisited elements.
 *
There are 3 base condition at point
1) currentSum==target ---> result found.
2) currentSum>target ---> return
3) currentSum < target ---> in loop for unvisited element call partition.

========================================================================================================
When (currentSum==target) we start the recursion again from 0.
It might seem like un-necessary flow will be executed. but un-necessary combination is avoided by isVisited.
Ex:  Input: [3,1,1,4,4,2] 3 k=3  sum=15 target=5

At Index2 We found 1 answer. But again recursion starts from Index0,1,2 But they are skipped

========================================================================================================
Input: [3,1,1,4,4,2] 3 k=3  sum=15 target=5
[true, false, false, false, false, false] ==> 3,1,1,4,4,2
[true, true, false, false, false, false] ==> 1,1,4,4,2
[true, true, true, false, false, false] ==> 1,4,4,2
[true, true, true, false, false, false] ==> 3,1,1,4,4,2 ==> un-necessary flow
[true, true, true, false, false, false] ==> 1,1,4,4,2 ==> un-necessary flow
[true, true, true, false, false, false] ==> 1,4,4,2 ==> un-necessary flow
[true, true, true, true, false, false]  ==> 4,4,2
[true, true, true, true, true, false]  ==> 4,4
[true, true, true, true, false, false] ==> return
[true, true, true, true, false, true] ==> 4,2(index 3 and 5)
[true, true, true, true, false, false] ==> return
[true, true, true, false, false, false] ==> return
[true, true, true, false, true, false] ==> 4,2(index 4 and 5)
[true, true, true, false, true, true] ==>
[true, true, true, false, true, false]
[true, true, true, false, false, false]
[true, true, true, false, false, true]
[true, true, true, false, false, false]
[true, true, false, false, false, false]


 */
public class PartitionToKEqualSumSubsetsBackTrack {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (k <= 0 || sum % k != 0) return false;
    canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);
    return result;
  }

  private boolean result = false;

  private void canPartition(
      int[] nums, boolean[] isVisited, int startIndex, int k, int currentSum, int target) {
    if (result || currentSum > target) return;
    // When k-1 combo, remaining 1 combo has to match. so checking for k==1 rather than k==0
    if (k == 1) {
      result = true;
      return;
    }
    if (currentSum == target) {
      canPartition(nums, isVisited, 0, k - 1, 0, target);
      return;
    }
    for (int i = startIndex; i < nums.length; i++) {
      System.out.println(Arrays.toString(isVisited));
      if (!isVisited[i]) {
        isVisited[i] = true;
        canPartition(nums, isVisited, i + 1, k, currentSum + nums[i], target);
        isVisited[i] = false;
      }
    }
  }
}
