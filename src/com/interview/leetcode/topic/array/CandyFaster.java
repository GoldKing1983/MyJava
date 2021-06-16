package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*

Reduced 4 loops to 2 loops.

 */
public class CandyFaster {
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) { // Ex: 1,2,3.. Compare 1and2. Then 2and3
      int current = ratings[i]; // 2 
      int previous = ratings[i - 1];// 1
      if (current > previous) { // 2>1
        dp[i] = dp[i - 1] + 1;
      }
    }
    // Ex: 1,2,3 or 3,2,1... At this point index2 answer cannot change. So sum is index2
    int sum = dp[n - 1];

    for (int i = n - 2; i >= 0; i--) { // Ex: 3,2,1.. Compare 2and1. Then 3and2
      int current = ratings[i]; // 2
      int next = ratings[i + 1]; // 1
      if (current > next) {// 2>1
        dp[i] = Math.max(dp[i], dp[i + 1] + 1);
      }
      sum += dp[i];
    }

    return sum;
  }

}
