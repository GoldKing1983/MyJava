package com.sample.datastructure.tree.dfs;

/*
 * https://leetcode.com/problems/target-sum/description/
https://www.educative.io/courses/grokking-the-coding-interview/JE0BWB8DgAJ

Requirement:
1) Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
2) All numbers should be included in result.

Input: {1, 1, 2, 3}, S=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}

Input: {1, 2, 7, 1}, S=9
Output: 2
Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
=============================================================================================================================
    => Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = S + Sum(num)
    => 2 * Sum(s1) =  S + Sum(num)
    => Sum(s1) = (S + Sum(num)) / 2

 count of (S + Sum(num)) / 2 is the answer

 */
public class TargetSumDp {

  public int findTargetSumWays(int[] nums, int s) {
    int sum = 0;
    for (int n : nums) sum += n;
    return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
  }

  public int subsetSum(int[] nums, int s) {
    int[] dp = new int[s + 1];
    dp[0] = 1;
    for (int n : nums) {
      for (int i = s; i >= n; i--) {
        dp[i] += dp[i - n];
      }
    }
    return dp[s];
  }
}
