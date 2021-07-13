package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/*
https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Input:[5,8,7,1,9]
Output: [5,8,9] or [5,7,9] size is 3.

======================================================================================================

See https://leetcode.com/problems/longest-increasing-subsequence/solution/ "Approach 3: Dynamic Programming" video...

Time Complexity is O(n^2)...LongestIncreasingSubSequenceBinarySearch is better than this
=======================================================Data Flow Analysis========================================================
1) For 2 number
           l r 
   Compare 0 1

2) For 3 number
           l r  
   Compare 0 1 2
           l   r 
   Compare 0 1 2
             l r 
   Compare 0 1 2



Ex: 1 2

outer loop run 1 time.. inner loop run 1 time..
2>1 
dp[1]=2


Ex: 1 2 3

outer loop run 2 time.. inner loop run 3 time..
loop1
2>1 
dp[1]=2

loop2
3>1
dp[2] = 2

3>2
dp[2] = 3

 
 */
public class LongestIncreasingSubSequenceDP {

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int right = 1; right < nums.length; right++) {
      for (int left = 0; left < right; left++) {
        if (nums[right] > nums[left]) {
          dp[right] = Math.max(dp[right], dp[left] + 1);
        }
      }
    }

    int longest = 0;
    for (int c : dp) {
      longest = Math.max(longest, c);
    }

    return longest;
  }
}
