package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/533754/I-believe-my-solution-is-the-most-intuitive-with-pictures-(2-variables-to-keep-track-of)
See Also MinCostClimbingStairs

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
====================================================================================================================================
There are four key cases pictured below.
	Case1 :The stock grows well, so we take profits day-to-day : [3,4,5,6,7]
	Case2 :The stock dropped, so we look back for a better deal: [3,4,5,1,7]
	Case3 :The stock dropped, so we look back for a better deal, but there's none of them: [3,4,7,2,3]
	Case4: The stock has dropped on the last trading day. This is the case to explain the need of the
	last return Max statement, so we take the previous day's profit (3), not the last one (2): [3,4,5,6,2]
====================================================================================================================================
 */
public class BestTimeToBuyAndSellStockWithCooldown {
  public int maxProfit(int[] prices) {
    if (prices == null) return 0;

    int fN = 0; // todays Profit
    int fNMinus1 = 0; // yesterdays Profit
    int fNMinus2 = 0; // dayBeforeYesterdays Profit

    for (int i = 1; i < prices.length; i++) {
      fN = Math.max(prices[i] - prices[i - 1] + fNMinus1, fNMinus2);
      fNMinus2 = Math.max(fNMinus1, fNMinus2);
      fNMinus1 = fN;
    }

    return Math.max(fNMinus1, fNMinus2);
  }
}
