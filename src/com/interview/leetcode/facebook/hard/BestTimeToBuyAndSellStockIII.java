package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 * Just change logic of "lowestBuyPrice2"
 *
 *
 * ================
input:[1,2,3,4,5]...
maxProfit1:0 maxProfit2:0
maxProfit1:1 maxProfit2:1
maxProfit1:2 maxProfit2:2
maxProfit1:3 maxProfit2:3
maxProfit1:4 maxProfit2:4
==========================

input:[3,3,5,0,0,3,1,4]

lowestBuyPrice1:3 maxProfit1:0 lowestBuyPrice2:3  maxProfit2:0
lowestBuyPrice1:3 maxProfit1:0 lowestBuyPrice2:3  maxProfit2:0
lowestBuyPrice1:3 maxProfit1:2 lowestBuyPrice2:3  maxProfit2:2
lowestBuyPrice1:0 maxProfit1:2 lowestBuyPrice2:-2 maxProfit2:2
lowestBuyPrice1:0 maxProfit1:2 lowestBuyPrice2:-2 maxProfit2:2
lowestBuyPrice1:0 maxProfit1:3 lowestBuyPrice2:-2 maxProfit2:5----change here
lowestBuyPrice1:0 maxProfit1:3 lowestBuyPrice2:-2 maxProfit2:5
lowestBuyPrice1:0 maxProfit1:4 lowestBuyPrice2:-2 maxProfit2:6

=========================
 */
public class BestTimeToBuyAndSellStockIII {

  public int maxProfit(int[] prices) {
    int maxProfit1 = 0;
    int maxProfit2 = 0;
    int lowestBuyPrice1 = Integer.MAX_VALUE;
    int lowestBuyPrice2 = Integer.MAX_VALUE;

    for (int currentPrice : prices) {
      lowestBuyPrice1 = Math.min(lowestBuyPrice1, currentPrice);
      int currentProfit1 = currentPrice - lowestBuyPrice1;
      maxProfit1 = Math.max(maxProfit1, currentProfit1);

      // This is the only trick
      lowestBuyPrice2 = Math.min(lowestBuyPrice2, currentPrice - maxProfit1);
      int currentProfit2 = currentPrice - lowestBuyPrice2;
      maxProfit2 = Math.max(maxProfit2, currentProfit2);
    }
    return maxProfit2;
  }
}
