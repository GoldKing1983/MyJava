package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

===========================================================Requirement===========================================================
1) Given an integer array nums and an integer k. 
2) return true, if it is possible to divide this array into k non-empty subsets whose sums are all equal.
========================================================Solution Approach========================================================
1) Add currentNumber to currentSum and currentNumber to visited(to indicate we are adding this number to result). 

There are 3 base condition at point
2) currentSum==target ---> result found.
3) currentSum>target ---> return
4) currentSum < target ---> in loop for unvisited element call partition.

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
    return canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);

  }

  private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int currentSum,
      int targetSum) {
    if (k == 1) return true;

    if (currentSum > targetSum) return false;

    if (currentSum == targetSum) return canPartition(nums, visited, 0, k - 1, 0, targetSum);

    // loop executed when currentSum < targetSum
    for (int i = start; i < nums.length; i++) {

      if (visited[i]) continue;
      visited[i] = true;
      if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], targetSum)) return true;
      visited[i] = false;

    }

    return false;
  }
}
