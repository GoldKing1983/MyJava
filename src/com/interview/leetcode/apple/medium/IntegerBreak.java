package com.interview.leetcode.apple.medium;

/*
https://leetcode.com/problems/integer-break/

Given a positive integer n, break it into the sum of "at least" "two positive integers"
and maximize the product of those integers. Return the maximum product you can get.

  Input: 10
  Output: 36
  Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

==============================================================================================================
n=4.... Output=4..
list: [1] 			sum: 1 product:1
list: [1, 1] 		sum: 2 product:1
list: [1, 1, 1] 	sum: 3 product:1
list: [1, 1, 1, 1]  sum: 4 product:1
list: [1, 1, 1, 2]  sum: 5 product:2
list: [1, 1, 2] 	sum: 4 product:2
list: [1, 2] 		sum: 3 product:2
list: [1, 2, 1] 	sum: 4 product:2
list: [1, 2, 2] 	sum: 5 product:4
list: [2] 			sum: 2 product:2
list: [2, 1] 		sum: 3 product:2
list: [2, 1, 1] 	sum: 4 product:2
list: [2, 1, 2] 	sum: 5 product:4
list: [2, 2] 		sum: 4 product:4
==================================Solution Approach============================================================================
1) Similar to FactorCombinations
2) No BackTracking needed, because we are not saving result.
==================Why we need Memo============================================================================================
1) For that sum, if product exists.. don't calculate again.

*/
public class IntegerBreak {

  public int integerBreak(int n) {
    dfs(n, 1, 0);
    return maxProduct;
  }

  int maxProduct = Integer.MIN_VALUE;

  public void dfs(int n, int sum, int product) {
    if (sum == n) {
      maxProduct = Math.max(maxProduct, product);
      return;
    }
    if (sum > n) return;
    for (int i = 1; i <= Math.ceil(n / 2.0); i++) dfs(n, product * i, sum + i);
  }
}
