package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
==============================================Solution Approach - BruteForce - O(n^2)==============================================
1) Consider 0thDay value as minimumBuyPrice. 
    =======
2) Consider everyDayPrice as sellPrice.
3) Calculate todaysProfit. 
4) Update maxProfit from todaysProfit
5) Update minimumBuyPrice from todays price.
    
===================================================DP Thinking===============================================
For each of current days. Cache the lowestBuyPrice for "all of previous days". Use lowestBuyPrice as a buy price.
==============================================Solution Approach==============================================
For each of currentDay price, use previousLowestPrice as buyPrice and currentDay price as sellPrice..
Ex: For 5 day stocks. Keep Min of{Day1} as buyPrice. sellPrice at Day1Price.
					  Keep Min of{Day1, Day2} as buyPrice. Sell sellPrice Day2Price.
					  Keep Min of{Day1, Day2, Day3} as buyPrice. sellPrice at Day3Price.
					  Keep Min of{Day1, Day2, Day3, Day4} as buyPrice. sellPrice at Day4Price.
					  Keep Min of{Day1, Day2, Day3, Day4, Day5} as buyPrice. sellPrice at Day5Price.
=================================================================================================================
*/

public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int minimumBuyPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int sellPrice = prices[i];
      int todaysProfit = sellPrice - minimumBuyPrice;
      maxProfit = Math.max(maxProfit, todaysProfit);
      minimumBuyPrice = Math.min(minimumBuyPrice, prices[i]);
    }
    return maxProfit;
  }

}
