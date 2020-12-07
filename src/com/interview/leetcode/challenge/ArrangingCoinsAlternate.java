package com.interview.leetcode.challenge;

/*
https://leetcode.com/problems/arranging-coins/
    if (n == 0) return 0;
    if (n <= 2) return 1;
    if (n == 3) return 2;
=================================================Solution Approach - O(StepCount)===================================================
Previous stepCount is 1. Adding 2 to previous stepCount. Total  = 1 + 1 + 1 = 3
Previous stepCount is 2. Adding 4 to previous stepCount. Total  = 2 + 3 + 1 = 6
Previous stepCount is 3. Adding 7 to previous stepCount. Total  = 3 + 6 + 1 = 10
Previous stepCount is 4. Adding 11 to previous stepCount. Total = 4 + 10 + 1 = 15
Previous stepCount is 5. Adding 16 to previous stepCount. Total = 5 + 15 + 1 = 21
Previous stepCount is 6. Adding 22 to previous stepCount. Total = 6 + 21 + 1 = 28

 */
public class ArrangingCoinsAlternate {
  public int arrangeCoins(int n) {
    long coinsCount = 1;
    long stepCount = 1;
    while (coinsCount <= n) {
      coinsCount = stepCount + coinsCount + 1;
      stepCount++;
    }
    return (int) stepCount - 1;
  }
}
