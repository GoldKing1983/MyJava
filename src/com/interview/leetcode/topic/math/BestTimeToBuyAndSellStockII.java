package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
=========================================================Requirement=============================================================
Given an stock prices of array, Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
========================================================Solution Approach========================================================
1) Calculate todaysProfit for each day by taking todaysPriceAsSell and yestedaysPriceAsBuy.
2) If todaysProfit>0 add it to maxProfit.
3) Return maxProfit
=========================================================Analysis================================================================
1) Don't think and code as requirement says. Because in example1 it says buy at day1 and sell at day5
2) It might seem like we are doing multiple transactions.
Ex: 1 100 200.... MaxProfit 199
How it should be: Buy at day1 and sell at day5 . Profit 199

	But we can code:buy at 1  -> sell at day2 100, Profit 99
					buy at 100-> sell at day3 200, Profit 99+100=199

Coding to "How it should be" is pretty large. Still we achieve the same. It is working because of number magic.
==================================================================================================================================
 */
public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      int profit = prices[i + 1] - prices[i]; // current and next

      if (profit > 0) maxProfit += profit;
    }
    return maxProfit;
  }
}
