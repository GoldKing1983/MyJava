package com.interview.leetcode.challenge;

/*
https://leetcode.com/problems/arranging-coins/
=================================================Solution Approach - O(log(n))===================================================
1) Formula approach is still O(log(n)) because of sqrt function.
2) So better option is Bin-Search rather than deriving the formula.

 */
public class ArrangingCoinsFormulaApproach {
  public int arrangeCoins(int n) {
    double xy = 4 * (double) 2 * n;
    double x = (-1 + Math.sqrt(1 + xy)) / 2;
    return (int) x;
  }
}
