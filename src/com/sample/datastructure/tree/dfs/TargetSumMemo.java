package com.sample.datastructure.tree.dfs;

/*
https://leetcode.com/problems/target-sum/description/

Requirement:
1) Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
2) All numbers should be included in result.

Input: {1, 1, 2, 3}, target=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}

Input: {1, 2, 7, 1}, target=9
Output: 2
Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}

============================================================Solution Approach========================================================
1) Similar to GroupSum Problem.
2) Recurse for + and -.
3) Why Memo : For that index of Number. If the sum is calculated already I can re-use it.

Reason why "2 * sum + 1". The currSum will go into "negative" for some input, because of subtraction.
To avoid "indexOutOfBoundException" in "cache[numIndex][currSum]" logic.
We set "currSum to sum" and "target to sum+target".

Ex:  Input: {1, 2, 7, 1}, S=9
sum = 11, target=9.....
Regular Approach :  currSum as 0  and target as 9.
Current Approach : currSum as 11 and target as 20.

Both yields same result without Memoization. In case of Memoization "Regular Approach" will throw "indexOutOfBoundException".
=====================================================================================================================================
 */
public class TargetSumMemo {

  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) sum += num;
    Integer[][] cache = new Integer[nums.length][2 * sum + 1];

    return dfs(nums, sum, target + sum, 0, cache);
  }

  private int dfs(int[] nums, int currSum, int target, int numIndex, Integer[][] cache) {
    if (numIndex == nums.length) {
      return currSum == target ? 1 : 0;
    }
    if (cache[numIndex][currSum] != null) {
      return cache[numIndex][currSum];
    }

    int netSum =
        dfs(nums, currSum + nums[numIndex], target, numIndex + 1, cache)
            + dfs(nums, currSum - nums[numIndex], target, numIndex + 1, cache);

    cache[numIndex][currSum] = netSum;
    return netSum;
  }
}
